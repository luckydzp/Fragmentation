package me.yokeyword.sample.demo_wechat;

import android.os.Bundle;

import androidx.annotation.Nullable;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_wechat.ui.fragment.LoginFragment;
import me.yokeyword.sample.demo_wechat.ui.fragment.MainFragment;
import me.yokeyword.sample.demo_wechat.ui.fragment.SplashFragment;

/**
 * 仿微信交互方式Demo
 * Created by YoKeyword on 16/6/30.
 * Modify by xuexuan on 2020年1月16日16:37:10
 * 修改后，加入SplashFragment、LoginFragment。这样的跳转关系和内存重启后的判断很关键，如果处理不当，容易出现崩溃
 *
 */
public class MainActivity extends SupportActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_activity_main);

        //这里需要如下判断，否则可能出现这个错误https://xuexuan.blog.csdn.net/article/details/103733622
        if (findFragment(MainFragment.class) == null
                && findFragment(LoginFragment.class) == null
                && findFragment(SplashFragment.class) == null) {
            loadRootFragment(R.id.fl_container, SplashFragment.newInstance());
        }
    }

    @Override
    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }
}
