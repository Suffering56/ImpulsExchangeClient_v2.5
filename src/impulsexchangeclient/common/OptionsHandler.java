package impulsexchangeclient.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class OptionsHandler {

    /**
     * Инициализация всех объектов необходимых, для дальнейшей работы с XML.
     * Должна быть выполнена при запуске программы. В противном случае не будут
     * работать все остальные функции класса OptionsHandler
     */
    public static void init() throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        XPathFactory xpfactory = XPathFactory.newInstance();
        xPath = xpfactory.newXPath();
        doc = builder.parse(xmlFile);
    }

    /**
     * Сохраняет измененния настроек в XML-файле "options.xml"
     *
     * @param switchParam Параметр, указывающий на то, какой именно раздел опций
     * нужно сохранить в XML файле. Всего их 4 вида: "Deptarment", "FTP",
     * "Firebird", "MySQL".
     */
    public static void saveOptions(String switchParam) {
        try {
            switch (switchParam) {
                case "Department":
                    saveDepartmentOptions();
                case "FTP":
                    saveFtpOptions();
                case "Firebird":
                    saveFirebirdOptions();
                case "MySQL":
                    saveMySqlOptions();
                case "ADMIN":
                    saveAdminOptions();
            }

            FileOutputStream out = new FileOutputStream(xmlFile);
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(out));
            out.close();
        } catch (DOMException | IOException | TransformerException | XPathExpressionException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка при сохранении настроек программы: \r\n"
                    + "ex.toString(): " + ex.toString(), "OptionsHandler.saveOptions()", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void replaceNode(Element section, String nodePath, String value) throws XPathExpressionException {
        Node oldNode = (Node) xPath.evaluate(nodePath, doc, XPathConstants.NODE);
        Node newNode = oldNode.cloneNode(true);
        newNode.setTextContent(value);
        section.replaceChild(newNode, oldNode);
    }

    private static void saveDepartmentOptions() throws XPathExpressionException {
        Element section = (Element) xPath.evaluate("Options/Department", doc, XPathConstants.NODE);
        String nodePath = "Options/Department/DepartmentName";
        replaceNode(section, nodePath, Service.encode(Options.getDepartmentName()));
        nodePath = "Options/Department/SwndFilePath";
        replaceNode(section, nodePath, Options.getSwndFilePath());
        nodePath = "Options/Department/SwndFileName";
        replaceNode(section, nodePath, Options.getSwndFileName());
    }

    private static void saveFtpOptions() throws XPathExpressionException {
        Element section = (Element) xPath.evaluate("Options/FTP", doc, XPathConstants.NODE);
        String nodePath = "Options/FTP/Address";
        replaceNode(section, nodePath, Service.encode(Options.getFtpAddress()));
        nodePath = "Options/FTP/Login";
        replaceNode(section, nodePath, Service.encode(Options.getFtpLogin()));
        nodePath = "Options/FTP/Password";
        replaceNode(section, nodePath, Service.encode(Options.getFtpPassword()));
    }

    private static void saveFirebirdOptions() throws XPathExpressionException {
        Element section = (Element) xPath.evaluate("Options/Firebird", doc, XPathConstants.NODE);
        String nodePath = "Options/Firebird/DatabasePath";
        replaceNode(section, nodePath, Options.getFirebirdDatabasePath());
        nodePath = "Options/Firebird/User";
        replaceNode(section, nodePath, Service.encode(Options.getFirebirdUser()));
        nodePath = "Options/Firebird/Password";
        replaceNode(section, nodePath, Service.encode(Options.getFirebirdPassword()));
        nodePath = "Options/Firebird/Encoding";
        replaceNode(section, nodePath, Options.getFirebirdEncoding());
        nodePath = "Options/Firebird/FBServerPath";
        replaceNode(section, nodePath, Options.getFbserverPath());
    }

    private static void saveMySqlOptions() throws XPathExpressionException {
        Element section = (Element) xPath.evaluate("Options/MySQL", doc, XPathConstants.NODE);
        String nodePath = "Options/MySQL/Address";
        replaceNode(section, nodePath, Service.encode(Options.getMySqlAddress()));
        nodePath = "Options/MySQL/Port";
        replaceNode(section, nodePath, Service.encode(Options.getMySqlPort()));
        nodePath = "Options/MySQL/DatabaseName";
        replaceNode(section, nodePath, Service.encode(Options.getMySqlDatabaseName()));
        nodePath = "Options/MySQL/User";
        replaceNode(section, nodePath, Service.encode(Options.getMySqlUser()));
        nodePath = "Options/MySQL/Password";
        replaceNode(section, nodePath, Service.encode(Options.getMySqlPassword()));
    }

    private static void saveAdminOptions() throws XPathExpressionException {
        Element section = (Element) xPath.evaluate("Options/Admin", doc, XPathConstants.NODE);
        String nodePath = "Options/Admin/Password";
        replaceNode(section, nodePath, Service.encode(Options.getAdminPassword()));
    }

    /**
     * Чтение настроек, хранящихся в файле "options.xml" и их дальнейшая
     * установка в качестве значений полей класса "Options".
     */
    public static void readOptions() {
        try {
            init();
            //Чтение настроек отдела
            Node currentNode = (Node) xPath.evaluate("Options/Department/DepartmentName", doc, XPathConstants.NODE);
            Options.setDepartmentName(Service.decode(currentNode.getTextContent()));
            currentNode = (Node) xPath.evaluate("Options/Department/SwndFilePath", doc, XPathConstants.NODE);
            Options.setSwndFilePath(currentNode.getTextContent());
            currentNode = (Node) xPath.evaluate("Options/Department/SwndFileName", doc, XPathConstants.NODE);
            Options.setSwndFileName(currentNode.getTextContent());

            //Чтение настроек FTP
            currentNode = (Node) xPath.evaluate("Options/FTP/Address", doc, XPathConstants.NODE);
            Options.setFtpAddress(Service.decode(currentNode.getTextContent()));
            currentNode = (Node) xPath.evaluate("Options/FTP/Login", doc, XPathConstants.NODE);
            Options.setFtpLogin(Service.decode(currentNode.getTextContent()));
            currentNode = (Node) xPath.evaluate("Options/FTP/Password", doc, XPathConstants.NODE);
            Options.setFtpPassword(Service.decode(currentNode.getTextContent()));

            //Чтение настроек Firebird
            currentNode = (Node) xPath.evaluate("Options/Firebird/DatabasePath", doc, XPathConstants.NODE);
            Options.setFirebirdDatabasePath(currentNode.getTextContent());
            currentNode = (Node) xPath.evaluate("Options/Firebird/User", doc, XPathConstants.NODE);
            Options.setFirebirdUser(Service.decode(currentNode.getTextContent()));
            currentNode = (Node) xPath.evaluate("Options/Firebird/Password", doc, XPathConstants.NODE);
            Options.setFirebirdPassword(Service.decode(currentNode.getTextContent()));
            currentNode = (Node) xPath.evaluate("Options/Firebird/Encoding", doc, XPathConstants.NODE);
            Options.setFirebirdEncoding(currentNode.getTextContent());
            currentNode = (Node) xPath.evaluate("Options/Firebird/FBServerPath", doc, XPathConstants.NODE);
            Options.setFbserverPath(currentNode.getTextContent());

            //Чтение настроек MySQL
            currentNode = (Node) xPath.evaluate("Options/MySQL/Address", doc, XPathConstants.NODE);
            Options.setMySqlAddress(Service.decode(currentNode.getTextContent()));
            currentNode = (Node) xPath.evaluate("Options/MySQL/Port", doc, XPathConstants.NODE);
            Options.setMySqlPort(Service.decode(currentNode.getTextContent()));
            currentNode = (Node) xPath.evaluate("Options/MySQL/DatabaseName", doc, XPathConstants.NODE);
            Options.setMySqlDatabaseName(Service.decode(currentNode.getTextContent()));
            currentNode = (Node) xPath.evaluate("Options/MySQL/User", doc, XPathConstants.NODE);
            Options.setMySqlUser(Service.decode(currentNode.getTextContent()));
            currentNode = (Node) xPath.evaluate("Options/MySQL/Password", doc, XPathConstants.NODE);
            Options.setMySqlPassword(Service.decode(currentNode.getTextContent()));

            //Чтение настроек администратора
            currentNode = (Node) xPath.evaluate("Options/Admin/Password", doc, XPathConstants.NODE);
            Options.setAdminPassword(Service.decode(currentNode.getTextContent()));

        } catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException | DOMException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка чтения настроек программы: \r\n"
                    + "ex.toString(): " + ex.toString(), "OptionsHandler.readOptions()", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static XPath xPath;
    private static Document doc;
    private static final File xmlFile = new File(System.getProperty("user.dir") + File.separator + "options.xml");
}
