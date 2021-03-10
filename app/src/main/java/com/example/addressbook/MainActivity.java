package com.example.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //member variable===========
    private final boolean  D=true;
    private final String   TAG ="MainActivity";

    //view object
    private EditText       nameETXT,phoneETXT,emailETXT;
    private TextView       addressTXT;


    //data
    private ArrayList<Address> addressList = new ArrayList<>();


    //member method -AppCompatActivity's override---------
    @Override
    protected void onCreate(Bundle savedInstanceState) { //화면을 생성하는
        super.onCreate(savedInstanceState);
        //activity 화면 설정 필수!!!
        setContentView(R.layout.activity_main);
        //xml view 객체 가져오기

        nameETXT=findViewById(R.id.nameETXT);
        phoneETXT=findViewById(R.id.phoneETXT);
        emailETXT=findViewById(R.id.emailETXT);
        addressTXT=findViewById(R.id.addressTXT);

        if(D)Log.i(TAG,"onCreate()");

    }
    //member method -xml onclick-------------------
    public void click(View v) {

        switch (v.getId()) {
            case R.id.addBTN:
                //3개의 입력 editText 값 읽어서 address 객체 생성 및 추가
                //(1) 3개 editText 값 입력 여부 체크
                if (nameETXT.getText().length() > 0 && phoneETXT.getText().length() > 0 && emailETXT.getText().length() > 0) {
                    //(2-1) Address 객체 생성 ArrayList 추가
                    addressList.add(new Address(nameETXT.getText().toString(),
                            phoneETXT.getText().toString(),
                            emailETXT.getText().toString()));
                    Log.i(TAG, "add=> " + addressList.size());

                    //3개 입력 필드 초기화(지우기)
                    initETXT();//추가하고 난 뒤 초기화

                    //address 에 데이터 출력
                    address();
//                    String data = "";
//                    for (int idx = 0; idx < addressList.size(); idx++)
//                        data += addressList.get(idx).getInfo() + "\n"; //데이터 가져오기
//                    addressTXT.setText(data);
                } else {
                    //(2-2) 사용자에게 알림 띄우기
                    Toast.makeText(this, R.string.add_msg, Toast.LENGTH_LONG).show();
                }


                break;


            case R.id.delBTN:
                // 모두 삭제 또는 가장 최근에 추가한 데이터 삭제
                if (addressList.size() > 0) { //리스트 사이즈를 체크해서

                    int lastIdx = addressList.size() - 1;
                    addressList.remove(lastIdx); //데이터 지우기

                    //TextView에 데이터 출력
                    String data = "";
                    for (int idx = 0; idx < addressList.size(); idx++)
                        data += addressList.get(idx).getInfo() + "\n"; //데이터 가져오기
                    if (data.length() > 0) addressTXT.setText(data);
                    else addressTXT.setText(R.string.nothing);

                } else {

                    Toast.makeText(this, R.string.del_msg, Toast.LENGTH_LONG).show(); //없을때 삭제
                }
                break;
        }
    }
        //member method -custom--------

        //3개 입력 필드 초기화--------------
        private void initETXT (){
            nameETXT.setText("");
            phoneETXT.setText("");
            emailETXT.setText("");

        }

    //addresslist 출력 메서드---------
    private void address (){
            String data = "";
            for (int idx = 0; idx < addressList.size(); idx++)
                data += addressList.get(idx).getInfo() + "\n";
            if (data.length()>0)
                addressTXT.setText(data);
            else
                addressTXT.setText(R.string.nothing);

        }
}
