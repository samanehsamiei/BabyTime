package project.babytime;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class babyInformation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baby_information);

		Bundle extra = getIntent().getExtras();
		final String name = extra.getString("name");
		final String family = extra.getString("family");
		final String birthDay = extra.getString("birthDay");
		final String code = extra.getString("code");
		final String bloodGroup = extra.getString("bloodGroup");
		final String bime = extra.getString("bime");
		final String special = extra.getString("special");
		final String fatherName = extra.getString("fatherName");
		final String motherName = extra.getString("motherName");
		final String telNumber = extra.getString("telNumber");

		Typeface tf1 = Typeface.createFromAsset(getAssets(), "Fonts/yekan.ttf");
		// Typeface tf2 = Typeface.createFromAsset(getAssets(),
		// "Fonts/ARLRDBD.TTF");

		TextView tv1 = (TextView) findViewById(R.id.name);
		tv1.setText(name);
		tv1.setTypeface(tf1);

		TextView tv2 = (TextView) findViewById(R.id.family);
		tv2.setText(family);
		tv2.setTypeface(tf1);

		TextView tv3 = (TextView) findViewById(R.id.birthday);
		tv3.setText(birthDay);
		tv3.setTypeface(tf1);

		TextView tv4 = (TextView) findViewById(R.id.code);
		tv4.setText(code);
		tv4.setTypeface(tf1);

		TextView tv5 = (TextView) findViewById(R.id.bloodGroup);
		tv5.setText(bloodGroup);
		tv5.setTypeface(tf1);

		TextView tv6 = (TextView) findViewById(R.id.bime);
		tv6.setText(bime);
		tv6.setTypeface(tf1);

		TextView tv7 = (TextView) findViewById(R.id.special);
		tv7.setText(special);
		tv7.setTypeface(tf1);

		TextView tv8 = (TextView) findViewById(R.id.fatherName);
		tv8.setText(fatherName);
		tv8.setTypeface(tf1);

		TextView tv9 = (TextView) findViewById(R.id.motherName);
		tv9.setText(motherName);
		tv9.setTypeface(tf1);

		TextView tv10 = (TextView) findViewById(R.id.telNumber);
		tv10.setText(telNumber);
		tv10.setTypeface(tf1);
		
		Button edit = (Button) findViewById(R.id.editBtn);
		edit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent edit = new Intent(babyInformation.this,babyEdit.class);
				Bundle extra = new Bundle();
				extra.putString("name", name);
				extra.putString("family", family);
				extra.putString("birthDay", birthDay);
				extra.putString("code", code);
				extra.putString("bloodGroup", bloodGroup);
				extra.putString("bime", bime);
				extra.putString("special", special);
				extra.putString("fatherName", fatherName);
				extra.putString("motherName", motherName);
				extra.putString("telNumber", telNumber);
				edit.putExtras(extra);
				startActivity(edit);
			}
		});

	}

}
