package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import nativeapp.ios.epamiostestapp.TablePage;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuTablePage;
import static nativeapp.ios.epamiostestapp.TablePage.aSwitch;

public class TableTest extends IosApplicationInit {

    @Test
    public void tableTest() {
        menuTablePage.tap();
        System.out.println(TablePage.table.size());
        System.out.println(TablePage.table.getNamesOfCells());
        TablePage.table.switchToggleToOn(aSwitch);
        TablePage.table.switchToggleToOn(aSwitch);
        TablePage.table.tapButton("Page Second");

    }
}
