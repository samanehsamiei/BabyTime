package project.babytime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.DbHelper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

public class babyList extends Activity {

	static Typeface tf;

	static List<String> name;
	static List<String> family;
	static List<String> birthDay;
	static List<String> code;
	static List<String> bloodGroup;
	static List<String> bime;
	static List<String> special;
	static List<String> fatherName;
	static List<String> motherName;
	static List<String> telNumber;

	EfficientAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baby_list);

		InitalizeFont();
		InitilizeContents();

		ListView lv = (ListView) findViewById(R.id.list);
		adapter = new EfficientAdapter(this);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				Intent Show = new Intent(babyList.this, babyInformation.class);
				Bundle extra = new Bundle();
				extra.putString("name", name.get(position));
				extra.putString("family", family.get(position));
				extra.putString("birthDay", birthDay.get(position));
				extra.putString("code", code.get(position));
				extra.putString("bloodGroup", bloodGroup.get(position));
				extra.putString("bime", bime.get(position));
				extra.putString("special", special.get(position));
				extra.putString("fatherName", fatherName.get(position));
				extra.putString("motherName", motherName.get(position));
				extra.putString("telNumber", telNumber.get(position));
				Show.putExtras(extra);
				startActivity(Show);
			}
		});

	}

	void InitalizeFont() {
		tf = Typeface.createFromAsset(getAssets(), "Fonts/yekan.ttf");
	}

	void InitilizeContents() {
		name = new ArrayList<String>();
		family = new ArrayList<String>();
		code = new ArrayList<String>();
		birthDay = new ArrayList<String>();
		bloodGroup = new ArrayList<String>();
		bime = new ArrayList<String>();
		special = new ArrayList<String>();
		fatherName = new ArrayList<String>();
		motherName = new ArrayList<String>();
		telNumber = new ArrayList<String>();

		DbHelper mDbHelper = new DbHelper(this);
		SQLiteDatabase mDb = null;
		try {
			mDbHelper.createDataBase();
			mDbHelper.openDataBase();
			mDbHelper.close();
			mDb = mDbHelper.getReadableDatabase();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String sql = "select * FROM baby";

		Cursor c = mDb.rawQuery(sql, null);
		if (c != null) {
			while (c.moveToNext()) {
				name.add(c.getString(0));
				family.add(c.getString(1));
				birthDay.add(c.getString(2));
				code.add(c.getString(3));
				bloodGroup.add(c.getString(4));
				bime.add(c.getString(5));
				special.add(c.getString(6));
				fatherName.add(c.getString(7));
				motherName.add(c.getString(8));
				telNumber.add(c.getString(9));
			}
		}
	}

	private static class EfficientAdapter extends BaseAdapter implements
			Filterable {
		private LayoutInflater mInflater;

		public EfficientAdapter(Context context) {
			mInflater = LayoutInflater.from(context);
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.mylistadapter, null);

				holder = new ViewHolder();
				holder.tvName = (TextView) convertView
						.findViewById(R.id.adaptor_tv1);
				holder.tvName.setTypeface(tf);
				convertView.setTag(holder);

				holder.tvFamily = (TextView) convertView
						.findViewById(R.id.adaptor_tv2);
				holder.tvFamily.setTypeface(tf);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.tvName.setText(name.get(position));
			holder.tvFamily.setText(family.get(position));
			return convertView;
		}

		static class ViewHolder {
			TextView tvName;
			TextView tvFamily;
		}

		@Override
		public Filter getFilter() {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public int getCount() {
			return name.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}
	}

}
