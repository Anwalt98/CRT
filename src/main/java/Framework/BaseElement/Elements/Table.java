package Framework.BaseElement.Elements;

import Framework.BaseElement.BaseElement;
import Framework.BaseTableModel;
import Framework.Driver.Driver;
import Framework.Logger.CustomLogger;
import TestProject.User.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class Table extends BaseElement {
    public Table(String by) {
        super(by);
    }
    public HashMap getTableHeaderOrder() {
        CustomLogger.info("Получаем хешмапу с ключами - заголовками хедера, значениями - их позицией в таблице.");
        HashMap toReturn = new HashMap<>();
        List<WebElement> columnList = Driver.getDriver().findElements(by);
        for (int i = 0; i < columnList.size(); i++) {
            toReturn.put(columnList.get(i).getText(), i + 1);
        }
        return toReturn;
    }
    public static int findUserRaw(BaseTableModel baseTableModel, By by) {
        CustomLogger.info("Получаем ряд,в котором находится наш юзер в таблице.");
        for (int i = 0; i < Driver.getDriver().findElements(by).size(); i++) {
            if (Driver.getDriver().findElements(by).get(i).getText().equals(baseTableModel.getUniqueField())) {
                return i + 1;
            }
        }
        return -1;
    }
}
