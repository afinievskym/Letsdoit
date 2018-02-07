package com.company.afinievskym.letsdoit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Programmer on 07.02.2018.
 */

//  Слушатель для элементов списка в выдвижной панели
public class DrawerItemClickListener extends Fragment implements ListView.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener {
    MainActivity mainActivity;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


    public void selectItem(int position) {
        // Обновляем содержимое экрана, заменяя фрагменты
        Fragment fragment = new Fragment();
        Bundle args = new Bundle();
        args.putInt(DrawerFragment.Task_NUMBER, position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // обновим выбранный элемент списка и закрываем панель
        mainActivity.DrawerLayout.setItemChecked(position, true);
        mainActivity.setTitle(mainActivity.MyMenu[position]);
        //mainActivity.DrawerLayout.closeDrawer(mDrawerListView);
    }
}

