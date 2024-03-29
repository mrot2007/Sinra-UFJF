package br.ufjf.sinra.sinra.dieta;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufjf.sinra.sinra.R;

public class CustomDrawerAdapter extends ArrayAdapter<DrawerItem> {
 
      Context context;
      List<DrawerItem> drawerItemList;
      int layoutResID;
 
      public CustomDrawerAdapter(Context context, int layoutResourceID, List<DrawerItem> listItems) {
            super(context, layoutResourceID, listItems);
            this.context = context;
            this.drawerItemList = listItems;
            this.layoutResID = layoutResourceID;
 
      }
 
      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
 
            DrawerItemHolder drawerHolder;
            View view = convertView;
 
            if (view == null) {
                  LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                  drawerHolder = new DrawerItemHolder();
 
                  view = inflater.inflate(layoutResID, parent, false);
                  drawerHolder.ItemName = (TextView) view.findViewById(R.id.drawer_itemName);
                  drawerHolder.icon = (ImageView) view.findViewById(R.id.drawer_icon);
                  drawerHolder.counter = (TextView) view.findViewById(R.id.drawer_counter);
 
                  view.setTag(drawerHolder);
 
            } else {
                  drawerHolder = (DrawerItemHolder) view.getTag();
 
            }
 
            DrawerItem dItem = (DrawerItem) this.drawerItemList.get(position);
 
            drawerHolder.icon.setImageDrawable(view.getResources().getDrawable(dItem.getImgResID()));
            drawerHolder.ItemName.setText(dItem.getItemName());
            if(dItem.getItemName()=="Dietas"){
                drawerHolder.counter.setVisibility(View.VISIBLE);
                drawerHolder.counter.setEnabled(true);
                drawerHolder.counter.setText("0");
            }
 
            return view;
      }
 
      private static class DrawerItemHolder {
            TextView ItemName;
            ImageView icon;
            TextView counter;
      }
}