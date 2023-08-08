package main.menu.Vue;

import main.menu.menu.Menu;

import java.util.Map;

public interface MenuVue {

    String getChoice(Menu menu);

    void affiche(Map<String, String> map);
}
