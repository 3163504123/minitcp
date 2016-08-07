package com.ptb.zeus.common.utils;


import com.ptb.zeus.common.utils.sendMail.EmailManager;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by MyThinkpad on 2015/11/25.
 */
public class MailSender {

    private static final String[] segKey = {"任务名", "文章标题", "微信号", "文章地址", "监控起始时间", "监控结束时间", "备注"};
    private static final String[] segName = {"taskName", "title", "weixinid", "url", "sTime", "eTime", "desc"};
    private static final String mailFilePathLinux = "/opt/mailFile/";
    private static final String mailFilePathWindo = "F:\\";

    private static EmailManager emailManager = new EmailManager();

    public static boolean sendActivationMail(String userName, String email, String url) {
        return emailManager.setActivationEmailBody(userName, email, url);
    }

    public static boolean sendExpireMail(Map map) {
        return emailManager.setExpireEmailBody(map);
    }

    public static boolean sendExpireMailWithFile(Map map) {
        try {
            //if (exportInfoToFile(map))
            return emailManager.setExpireEmailBody(map);
        } catch (Exception ee) {
            ee.printStackTrace();
            System.out.println(ee.getMessage());
        }
        return false;
    }

    private static  boolean exportInfoToFile(Map map) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(map.get("taskName").toString());

        HSSFRow row = null;
        int ii = 0;
        HSSFCellStyle keyStyle = setStyle(wb, "宋体", (short) 12, false, HSSFCellStyle.VERTICAL_CENTER, true);
        HSSFCellStyle boldStyle = setStyle(wb, "宋体", (short) 12, true, HSSFCellStyle.VERTICAL_CENTER, true);
        for (; ii < segKey.length; ii++) {
            row = sheet.createRow(ii);
            row.setHeight((short) 430);
            row.createCell(0).setCellValue(segKey[ii]);
            row.getCell(0).setCellStyle(keyStyle);

            if (ii == 3) {
                row.createCell(1).setCellValue("查看原文");
            } else {
                row.createCell(1).setCellValue(map.get(segName[ii]).toString());
            }
            if (ii == 0)
                row.getCell(1).setCellStyle(boldStyle);
            else if (ii == 3) {
                row.getCell(1).setCellStyle(setStyleHyperlink(wb, "宋体", (short) 12, true, HSSFCellStyle.VERTICAL_CENTER, true));
                row.getCell(1).setHyperlink(setHyperlink(wb, map.get(segName[ii]).toString()));
            } else
                row.getCell(1).setCellStyle(keyStyle);

            row.createCell(2);
            sheet.addMergedRegion(new CellRangeAddress(ii, ii, 1, 2));
        }

        HSSFCellStyle segStyle = setStyle(wb, "宋体", (short) 12, false, HSSFCellStyle.ALIGN_CENTER, true);

        row = sheet.createRow(ii);
        row.setHeight((short) 430);
        sheet.addMergedRegion(new CellRangeAddress(ii, ii, 0, 2));

        ii++;
        row = sheet.createRow(ii);
        row.setHeight((short) 430);
        row.createCell(0).setCellValue("监控时间");
        row.getCell(0).setCellStyle(segStyle);
        row.createCell(1).setCellValue("阅读数");
        row.getCell(1).setCellStyle(segStyle);
        row.createCell(2).setCellValue("点赞数");
        row.getCell(2).setCellStyle(segStyle);
        ii++;

        HSSFCellStyle valStyle = setStyle(wb, "宋体", (short) 10, false, HSSFCellStyle.ALIGN_CENTER, false);
        Map infoMap = (Map) map.get("info");
        Map itemMap = null;
        for (int kk = 0; kk < infoMap.size(); kk++) {
            itemMap = (Map) infoMap.get(kk);
            row = sheet.createRow(ii++);
            row.setHeight((short) 430);
            row.createCell(0).setCellValue(itemMap.get("timestamp").toString());
            row.getCell(0).setCellStyle(valStyle);
            row.createCell(1).setCellValue(itemMap.get("readnum").toString());
            row.getCell(1).setCellStyle(valStyle);
            row.createCell(2).setCellValue(itemMap.get("zannum").toString());
            row.getCell(2).setCellStyle(valStyle);
        }

        sheet.setColumnWidth(0, 5000);
        sheet.setColumnWidth(1, 8064);
        sheet.setColumnWidth(2, 5760);

        String filename = null;
        if (-1 < System.getProperties().getProperty("os.name").toLowerCase().indexOf("win")) {
            filename = mailFilePathWindo + map.get("userName").toString().split("@")[0] + "." + map.get("taskName") + ".xls";
        } else {
            filename = mailFilePathLinux + map.get("userName").toString().split("@")[0] + "." + map.get("taskName") + ".xls";
        }

        FileOutputStream fileOut = new FileOutputStream(filename);
        wb.write(fileOut);
        fileOut.close();

        wb.close();

        map.put("file", filename);
        return true;
    }

    private static HSSFCellStyle setStyle(HSSFWorkbook wb, String fontType, short fontSize, boolean bold, short align, boolean position) {
        HSSFCellStyle style = wb.createCellStyle();
        if (-1 == align)
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //设置对齐方式
        else
            style.setAlignment(align);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        HSSFFont font = wb.createFont();             //设置字体
        if (null == font)
            font.setFontName("宋体");
        else
            font.setFontName(fontType);

        if (-1 == fontSize)
            font.setFontHeightInPoints((short) 11);
        else
            font.setFontHeightInPoints(fontSize);

        if (bold)
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        style.setFont(font);

        style.setWrapText(position);

        return style;
    }

    public static HSSFCellStyle setStyleHyperlink(HSSFWorkbook wb, String fontType, short fontSize, boolean bold, short align, boolean position) {
        HSSFCellStyle linkStyle = wb.createCellStyle();
        if (-1 == align)
            linkStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //设置对齐方式
        else
            linkStyle.setAlignment(align);
        linkStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        HSSFFont font = wb.createFont();             //设置字体
        if (null == font)
            font.setFontName("宋体");
        else
            font.setFontName(fontType);

        if (-1 == fontSize)
            font.setFontHeightInPoints((short) 11);
        else
            font.setFontHeightInPoints(fontSize);

        font.setColor(HSSFColor.BLUE.index);

        if (bold)
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        linkStyle.setFont(font);

        linkStyle.setWrapText(position);

        return linkStyle;
    }

    public static HSSFHyperlink setHyperlink(HSSFWorkbook wb, String link) {
        HSSFCreationHelper createHelper = wb.getCreationHelper();
        HSSFHyperlink hLink = createHelper.createHyperlink(HSSFHyperlink.LINK_URL);
        hLink.setAddress(link);
        return hLink;
    }

    public static boolean sendFindPasswordEmail(String username, String email, String url) {
        return emailManager.setFindPasswordEmailBody(username, email, url);
    }
}
