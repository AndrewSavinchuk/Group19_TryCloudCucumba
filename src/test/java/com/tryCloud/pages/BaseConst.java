package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseConst {

    public BaseConst() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
