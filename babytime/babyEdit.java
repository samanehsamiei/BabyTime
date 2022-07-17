package project.babytime;

import java.io.IOException;

import util.DbHelper;
import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class babyEdit extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baby_edit);

		Bundle extra = getIntent().getExtras();
		String name = extra.getString("name");
		String family = extra.getString("family");
		String birthDay = extra.getString("birthDay");
		String code = extra.getString("code");
		String bloodGroup = extra.getString("bloodGroup");
		String bime = extra.getString("bime");
		String special = extra.getString("special");
		String fatherName = extra.getString("fatherName");
		String motherName = extra.getString("motherName");
		String telNumber = extra.getString("telNumber");

		final EditText tv1 = (EditText) findViewById(R.id.name);
		tv1.setText(name);

		final EditText tv2 = (EditText) findViewById(R.id.family);
		tv2.setText(family);

		final EditText tv3 = (EditText) findViewById(R.id.birthday);
		tv3.setText(birthDay);

		final EditText tv4 = (EditText) findViewById(R.id.code);
		tv4.setText(code);

		final EditText tv5 = (EditText) findViewById(R.id.bloodGroup);
		tv5.setText(bloodGroup);

		final EditText tv6 = (EditText) findViewById(R.id.bime);
		tv6.setText(bime);

		final EditText tv7 = (EditText) findViewById(R.id.special);
		tv7.setText(special);

		final EditText tv8 = (EditText) findViewById(R.id.fatherName);
		tv8.setText(fatherName);

		final EditText tv9 = (EditText) findViewById(R.id.motherName);
		tv9.setText(motherName);

		final EditText tv10 = (EditText) findViewById(R.id.telNumber);
		tv10.setText(telNumber);

		Button edit = (Button) findViewById(R.id.save);
		edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String name1 = tv1.getText().toString();
				String family1 = tv2.getText().toString();
				String birthDay1 = tv3.getText().toString();
				String code1 = tv4.getText().toString();
				String bloodGroup1 = tv5.getText().toString();
				String bime1 = tv6.getText().toString();
				String special1 = tv7.getText().toString();
				String fatherName1 = tv8.getText().toString();
				String motherName1 = tv9.getText().toString();
				String telNumber1 = tv10.getText().toString();

				Update(name1, family1, birthDay1, code1, bloodGroup1, bime1,
						special1, fatherName1, motherName1, telNumber1);

				TextView tv = (TextView) findViewById(R.id.Message);
				tv.setText("information updated");
			}
		});

	}

	void Update(String name, String family, String birthDay, String code,
			String bloodGroup, String bime, String special, String fatherName,
			String motherName, String telNumber) {

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
		try {
			String sql = "update baby set name='" + name + "' , family='" + family + "' , birthDay='" + birthDay + "' , code='"	+ code + "' , bloodGroup='"	+ bloodGroup
					+ "' , bime='" + bime + "' , special='"	+ special + "' , fatherName='" + fatherName	+ "' , motherName='" + motherName + "' , telNumber='" + telNumber + "' where code='" + code + "'";

			mDb.execSQL(sql);
			mDb.close();

		} catch (SQLException mSQLException) {
			throw mSQLException;
		}
	}

}
