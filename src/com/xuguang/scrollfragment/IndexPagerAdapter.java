package com.xuguang.scrollfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


public class IndexPagerAdapter extends FragmentPagerAdapter {

	public IndexPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	List<Fragment> fragments;

	public IndexPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}

}
