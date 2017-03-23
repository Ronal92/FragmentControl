package com.jinwoo.android.fragmentcontrol;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    // 1. 사용할 프래그먼트 선언
    ListFragment list;
    DetailFragment detail;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 2. fragment 생성
        list = new ListFragment();
        detail = new DetailFragment();

        list.setActivity(this);
        detail.setActivity(this);

        // 3. fragment manager 가져오기
        manager = getSupportFragmentManager();

        setList();

    }

    // Activity에 처음 목록이 세팅될 때
    public void setList(){

        // 1. fragment를 실행하기 위한 트랜잭션 시작.
         FragmentTransaction transaction = manager. beginTransaction();
        // 2. fragment를 레이아웃에 add한다.  --  frame이 stack의 한 영역 안에서만 적재한다.
        transaction.add(R.id.frag, list);
        // 3. 커밋전에 트랜잭션 전체를 stack에 저장을 합니다. -- 트랜잭션 전체가 stack 영역에서 수직으로 적재된다.
        transaction.addToBackStack(null);
        // 4. git의 commit과 같은 기능
        transaction.commit();

    }
    // Detail 프래그먼트에서 List로 돌아갈 때
    public void backList(){

        // 스택을 빼내면 된다. - popBackStack에 해당된다.
//        super.onBackPressed();
        // 1. fragment를 실행하기 위한 트랜잭션 시작.
        FragmentTransaction transaction = manager. beginTransaction();
        // 2. detail 프래그먼트를 스택에서 제거한다. -- 스택에서 트랜잭션 전체가 제거되는게 아니라 frame만 없앤다.
        transaction.remove(detail);
        // 3. commit (최종적으로 화면에 반영된다.)
        transaction.commit();

    }

    // 리스트에서 상세로 이동할 때
    public void goDetail(){

        // 1. fragment를 실행하기 위한 트랜잭션 시작.
        FragmentTransaction transaction = manager. beginTransaction();
        // 2. fragment를 레이아웃에 add한다.
        transaction.add(R.id.frag, detail);
        // 3. 커밋전에 트랜잭션 전체를 stack에 저장을 합니다.
        transaction.addToBackStack(null);
        // 4. git의 commit과 같은 기능
        transaction.commit();
    }





}
