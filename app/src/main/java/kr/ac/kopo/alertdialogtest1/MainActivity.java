package kr.ac.kopo.alertdialogtest1;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn1 = findViewById(R.id.btn1);
        ImageView imgv = findViewById(R.id.imgv);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] foodItems = {"떡볶이", "군만두", "순대", "어묵"};
                final String[] foodImages = {"tokboki", "mandu", "sundae", "odeng"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("인공지능소프트웨어과 공지사항");
                dlg.setItems(foodItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setText(foodItems[which]); // 선택한 음식 리스트 반환
                        if(which == 0)
                        {
                            imgv.setImageResource(R.drawable.tokboki);
                        }
                        else if (which == 1)
                        {
                            imgv.setImageResource(R.drawable.mandu);
                        }
                        else if (which == 2)
                        {
                            imgv.setImageResource(R.drawable.sundae);
                        }
                        else
                        {
                            imgv.setImageResource(R.drawable.odeng);
                        }
                    }
                });
//                dlg.setMessage("정보처리산업기사 정기 2회 실기 6월 23일 ~ 26일까지 신청하시기 바랍니다.");
                dlg.setIcon(R.drawable.firefox);
                dlg.setPositiveButton("닫기", null);
//                dlg.setPositiveButton("확인", null);
//                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "취소버튼을 누르셨습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                });
                dlg.show();
            }
        });
    }
}