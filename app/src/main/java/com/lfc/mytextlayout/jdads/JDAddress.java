package com.lfc.mytextlayout.jdads;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lfc.mytextlayout.R;

import java.util.ArrayList;
import java.util.List;

import chihane.jdaddressselector.AddressProvider;
import chihane.jdaddressselector.AddressSelector;
import chihane.jdaddressselector.BottomDialog;
import chihane.jdaddressselector.OnAddressSelectedListener;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

public class JDAddress extends AppCompatActivity implements OnAddressSelectedListener {

    private LinearLayout activityJdaddress;
    private Button btnJd;

    private List<Province> mlist_p = new ArrayList<>();
    private List<City> mlist_C = new ArrayList<>();
    private List<County> mlist_CC = new ArrayList<>();
    private List<Street> mlist_S = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jdaddress);

        initView();
        getdata();
    }

    private void getdata() {

        for (int i = 0; i < 10; i++) {
            Province province = new Province();
            province.id = 0;
            province.name = "省份" + i;
            mlist_p.add(province);
        }
        for (int i = 0; i < 5; i++) {
            City province = new City();
            province.id = 0;
            province.name = "市" + i;
            mlist_C.add(province);
        }
        for (int i = 0; i < 8; i++) {
            County province = new County();
            province.id = 0;
            province.name = "县" + i;
            mlist_CC.add(province);
        }
        for (int i = 0; i < 4; i++) {
            Street province = new Street();
            province.id = 0;
            province.name = "区" + i;
            mlist_S.add(province);
        }
    }

    private void initView() {
        activityJdaddress = (LinearLayout) findViewById(R.id.activity_jdaddress);
        btnJd = (Button) findViewById(R.id.btn_jd);
        btnJd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomDialog dialog = new BottomDialog(JDAddress.this);
                dialog.setOnAddressSelectedListener(JDAddress.this);
                dialog.show();
            }
        });
        AddressSelector selector = new AddressSelector(JDAddress.this);
        selector.setAddressProvider(new AddressProvider() {
            @Override
            public void provideProvinces(AddressReceiver<Province> addressReceiver) {
//                List<Province> provinces = addressApi.provincesFromDatabase();
                addressReceiver.send(mlist_p);
            }

            @Override
            public void provideCitiesWith(int provinceId, AddressReceiver<City> addressReceiver) {
//                new Thread(() -> {
//                    List<City> cities = addressApi.citiesSync(provinceId);
//                    addressReceiver.send(cities);
//                }).start();

                addressReceiver.send(mlist_C);
            }

            @Override
            public void provideCountiesWith(int cityId, AddressReceiver<County> addressReceiver) {
//                addressApi.counties(cityId)
//                        .subscribeOn(Schedulers.io())
//                        .subscribe(
//                                counties -> addressReceiver.send(counties),
//                                throwable -> addressReceiver.send(null)
//                        );
                addressReceiver.send(mlist_CC);
            }

            @Override
            public void provideStreetsWith(int countyId, AddressReceiver<Street> addressReceiver) {
                // blahblahblah
                addressReceiver.send(mlist_S);

            }
        });
    }

    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {

        Toast.makeText(JDAddress.this, province.name + city.name + county.name + street.name, Toast.LENGTH_LONG).show();

    }
}
