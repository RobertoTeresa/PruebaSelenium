package com.appium.manager;

public class EmailHTML {

    public static String headHtml() {
        String headHtml = "<!DOCTYPE html>\n" +
                "<html lang=\"es\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <link id=\"u-page-google-font\" rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i\">\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <title></title>\n" +
                "  <style>\n" +
                "    table, td, div, h1, p {font-family: Arial, sans-serif;}\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "  <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "    <tr>\n" +
                "      <td align=\"center\" style=\"padding:0;\">\n" +
                "        <table role=\"presentation\" style=\"width:502px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "          <tr>\n" +
                "            <td align=\"center\" style=\"padding:30px 0 30px 0;background:#173962;\">\n" +
                "                <h1 style=\"color: #ffffff; font-size: 48px; font-family: Arial, sans-serif; line-height: 0.1;\">HIBERUS</h1>\n" +
                "                <h1 style=\"color: #00cde2; font-size: 20px; font-family: Arial, sans-serif; line-height: 0.1;\">Quality Assurance</h1>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:36px 30px 36px 30px;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"color:#153643;\">";
        return headHtml;
    }

    public static String footerHtml() {
        String footerHtml = "</td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:30px;background:#173962;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;font-size:9px;font-family:Arial,sans-serif;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"padding:0;width:50%;\" align=\"left\">\n" +
                "                    <p style=\"margin: 0px 0px 14px; font-size: 13px; font-family: Arial, sans-serif; color:#ffffff;\"><strong>HIBERUS QA</strong></p>\n" +
                "                    <p style=\"margin: 0px 0px 5px; font-size: 12px; font-family: Arial, sans-serif; color:#ffffff;\"><strong style=\" font-size: 14px;\">hiberus</strong> TECNOLOGÍA</p>\n" +
                "                    <p style=\"margin: 0px 0px 14px; font-size: 12px; font-family: Arial, sans-serif; color:#ffffff;\">#SomosHiberus #LasCosasOcurrenAqui #YoMeQuedoEnCasa</p>\n" +
                "                    <p style=\"margin: 0px 0px 5px; font-size: 12px; font-family: Arial, sans-serif; color:#ffffff;\">Edificio Hiberus</p>\n" +
                "                    <p style=\"margin: 0px 0px 5px; font-size: 12px; font-family: Arial, sans-serif; color:#ffffff;\">Paseo Isabel la Católica 6, 50009, Zaragoza (España)</p>\n" +
                "                    <p style=\"margin: 0px 0px 5px; font-size: 12px; font-family: Arial, sans-serif;\"><a style=\"color: #ffffff;\" href=\"http://www.example.com\">www.hiberus.com</a></p>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>";
        return footerHtml;
    }


}
