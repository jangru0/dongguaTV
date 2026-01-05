package com.ednovas.donguatv;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.WindowCompat;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // 设置边到边显示（让 WebView 可以扩展到状态栏和导航栏区域）
        // 由 CSS 的 safe-area-inset 来处理内容 padding
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        
        // 对于刘海屏/打孔屏，允许内容延伸到切口区域
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            getWindow().setAttributes(lp);
        }
        
        // 设置状态栏为透明（让网页背景显示出来）
        getWindow().setStatusBarColor(android.graphics.Color.TRANSPARENT);
    }
}
