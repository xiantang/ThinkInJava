package designpattern.iterator.a;

import java.util.ArrayList;

/**
 * @Author: xiantang
 * @Date: 2019/5/7 22:48
 */
public class CakeHouseMenu {
    private ArrayList<MenuItem> menuItems;

    public Iterator getIterator() {
        return new CakeHouseIterator();
    }


    class CakeHouseIterator implements Iterator {
        private int position = 0;

        public CakeHouseIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            if (position < menuItems.size()) {
                return true;
            }
            return false;
        }


        @Override
        public Object next() {
            MenuItem menuItem = menuItems.get(position);
            position++;
            return menuItem;
        }
    }

}
