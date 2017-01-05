package com.ptb.zeus.common.core.repository.impl;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2017/1/4
 * @version 1.0.0
 * @description 类的功能
 */
public abstract class AbstractMongoRespository {
	private static Logger logger = LoggerFactory.getLogger(AbstractMongoRespository.class);

	public Document toDocument(Object object) {
		return Document.parse(JSON.toJSONString(object));
	}

	public <T> T toObject(Document doc, Class<T> t) {
		return JSON.parseObject(JSON.toJSONString(doc), t);
	}

	protected abstract MongoDatabase getDatabase();

	/**
	 * upload file to mongo
	 */
	public  String uploadFileToGridFS(String filename, InputStream in) {
		//default bucket name is fs
		GridFSBucket bucket = GridFSBuckets.create(getDatabase());
		ObjectId fileId = bucket.uploadFromStream(filename, in);
		return fileId.toHexString();
	}

	/**
	 * upload file to mongo, if close is true then close the inputstream
	 */
	public String uploadFileToGridFS(String filename, InputStream in, boolean close) {
		String returnId = null;
		try {
			returnId = uploadFileToGridFS(filename, in);
		} finally {
			if (close) {
				try {
					in.close();
				} catch (IOException e) {
					logger.info("close inputstream fail:" + e);
				}
			}
		}
		return returnId;
	}

	/**
	 * upload file to mongo
	 */
	public  String uploadFileToGridFs(String fileName, File file) {
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			String returnId = uploadFileToGridFS(fileName, in, true);
			return returnId;
		} catch (IOException e) {
			logger.info("upload fail:" + e);
		}
		return null;
	}

	/**
	 * set filename = file name
	 */
	public  String uploadFileToGridFs(File file) {
		return uploadFileToGridFs(file.getName(), file);
	}

	/**
	 * set filename = uuid
	 */
	public  String uploadFileToGridFSByUUID(File file) {
		return uploadFileToGridFs(UUID.randomUUID().toString(), file);
	}

	/**
	 * download file for gridfs by objectid
	 */
	public  void downloadFile(String objectId, OutputStream out) {
		GridFSBucket bucket = GridFSBuckets.create(getDatabase());
		bucket.downloadToStream(new ObjectId(objectId), out);
	}


	public InputStream  getDownloadInputStream(String objectId) {
		GridFSBucket bucket = GridFSBuckets.create(getDatabase());
		return bucket.openDownloadStream(new ObjectId(objectId));
	}



	/**
	 * download file for gridfs by objectid
	 */
	public  void downloadFile(String objectId, File file) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			downloadFile(objectId, os);
		} catch (IOException e) {
			logger.info("download fail:" + e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.info("close outputstream fail:" + e);
				}
			}
		}
	}

	/**
	 * download file for gridfs by objectid
	 */
	public  void downloadFile(String objectId, String filename) {
		File file = new File(filename);
		downloadFile(objectId, file);
	}

	/**
	 * download file for gridfs by filename
	 */
	public  void downloadFileByName(String filename, OutputStream out) {
		GridFSBucket bucket = GridFSBuckets.create(getDatabase());
		bucket.downloadToStreamByName(filename, out);
	}

	/**
	 * download file for gridfs use stream
	 * 如果一次性读取所有字节，大于chunk size的可能会出现乱序，导致文件损坏
	 */
	public  void downloadFileUseStream(String objectId, OutputStream out) {
		GridFSBucket bucket = GridFSBuckets.create(getDatabase());
		GridFSDownloadStream stream = null;
		try {
			stream = bucket.openDownloadStream(new ObjectId(objectId));
			/** gridfs file */
			GridFSFile file = stream.getGridFSFile();
			/** chunk size */
			int size = file.getChunkSize();
			int len = (int) file.getLength();
			/** loop time */
			int cnt = len / size + (len % size == 0 ? 0 : 1);
			byte[] bts = new byte[Math.min(len, size)];
			try {
				while (cnt-- > 0) {
					int tmp = stream.read(bts);
					out.write(bts, 0, tmp);
				}
				out.flush();
			} catch (IOException e) {
				logger.info("download fail:");
			}
		} finally {
			if (stream != null) stream.close();
		}
	}


	/**
	 * download file for gridfs use stream
	 */
	public  void downloadFileUseStream(String objectId, String fileName) {
		File file = new File(fileName);
		downloadFileUseStream(objectId, file);
	}

	/**
	 * download file for gridfs use stream
	 */
	public  void downloadFileUseStream(String objectId, File file) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			downloadFileUseStream(objectId, os);
		} catch (IOException e) {
			logger.info("download fail:" + e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// skip
				}
			}
		}
	}

	/**
	 * 将mongo gridfs的文件下载到内存
	 */
	public  byte[] downloadFileUseStream(String objectId) {
		GridFSBucket bucket = GridFSBuckets.create(getDatabase());
		GridFSDownloadStream stream = null;
		try {
			stream = bucket.openDownloadStream(new ObjectId(objectId));
			/** gridfs file */
			GridFSFile file = stream.getGridFSFile();
			/** chunk size */
			int size = file.getChunkSize();
			int len = (int) file.getLength();
			int readSize = Math.min(len, size);
			byte[] returnBts = new byte[len];
			/** offset num */
			int offset = 0;
			while (len > 0) {
				int tmp;
				if (len > readSize) {
					tmp = stream.read(returnBts, offset, readSize);
					offset += tmp;
				} else {
					tmp = stream.read(returnBts, offset, len);
				}
				len -= tmp;
			}
			return returnBts;
		} finally {
			if (stream != null) stream.close();
		}
	}

	/**
	 * delete file from gridfs by objectId
	 */
	public  void deleteByObjectId(String objectId) {
		GridFSBucket bucket = GridFSBuckets.create(getDatabase());
		bucket.delete(new ObjectId(objectId));
	}
}




