package com.learningjava.learningspringboot.Controller;

import java.beans.PropertyEditorSupport;

public class FirstNamePropertyEditor extends PropertyEditorSupport {
    
    @Override
    public void setAsText(String text) {
        setValue(text.trim().toLowerCase());
    }
}
