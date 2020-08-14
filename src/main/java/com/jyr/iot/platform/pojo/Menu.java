package com.jyr.iot.platform.pojo;

public class Menu {
    private Integer menuId;

    private String menuName;

    private String menuImg;

    private String menuKey;

    private String menuUrl;

    private String menuAction;

    private Integer menuParentId;

    private Boolean menuHide;

    private String menuAuthUrl;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg == null ? null : menuImg.trim();
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey == null ? null : menuKey.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuAction() {
        return menuAction;
    }

    public void setMenuAction(String menuAction) {
        this.menuAction = menuAction == null ? null : menuAction.trim();
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public Boolean getMenuHide() {
        return menuHide;
    }

    public void setMenuHide(Boolean menuHide) {
        this.menuHide = menuHide;
    }

    public String getMenuAuthUrl() {
        return menuAuthUrl;
    }

    public void setMenuAuthUrl(String menuAuthUrl) {
        this.menuAuthUrl = menuAuthUrl == null ? null : menuAuthUrl.trim();
    }
}