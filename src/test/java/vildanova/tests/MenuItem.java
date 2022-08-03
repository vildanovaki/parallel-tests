package vildanova.tests;

public enum MenuItem {

    NEW("Новинки"),
    POPULAR("Популярное"),
    AUDIO("Аудиокниги");

    private String desc;

    MenuItem(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
