package com.xuguang.scrollfragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class TabContentActivity extends BaseTabFragment{
	private List<Fragment> fragmentsList = new ArrayList<Fragment>();

	public static TabContentActivity getInstance(Bundle args) {
		TabContentActivity creditFragment = new TabContentActivity();
		if (args != null) {
			creditFragment.setArguments(args);
		}
		return creditFragment;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
	}

	@Override
	public List<Fragment> addFragment() {
		fragmentsList.add(Fragment1.getInstance(null));
		fragmentsList.add(Fragment2.getInstance(null));
		fragmentsList.add(Fragment3.getInstance(null));
		return fragmentsList;
	}
}
