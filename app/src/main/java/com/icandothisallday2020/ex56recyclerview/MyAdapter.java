package com.icandothisallday2020.ex56recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<String> items;

    public MyAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull    //재활용할 뷰가 없으면 뷰를 만들어내는 작업을 수행하는 메소드
    @Override   //단 ViewHolder 객체를 만들어서 리턴
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.recycler_item,parent,false);
        //당장 붙이는 것이 아니라 사이즈 계산을 위해 parent 전달

        //뷰홀더 객체 생성 및 리턴
        VH holder=new VH(itemView);
        return holder                                                                                                                                        ;
    }

    @Override   //뷰에 값을 연결하는 메소드//┌뷰에 설정된 tag 값(ViewHolder)
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;//down casting
        vh.tv.setText(items.get(position));

    }

    @Override
    public int getItemCount() {return items.size();}


    //Inner Class:아이템뷰안에 있는 뷰들의 참조변수를 멤버변수로 가지는 클래스
    class  VH extends RecyclerView.ViewHolder {
        TextView tv;

        public VH(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            //Recycler item click 반응하는 리스너객체 생성 및 추가
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //이 아이템뷰의 위치 index 번호
                    int position=getLayoutPosition();
                    Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();
                }
            });//Listener
        }
    }

    }

