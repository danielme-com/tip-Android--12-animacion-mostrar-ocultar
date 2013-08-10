package com.danielme.tipsandroid.animacion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.danieme.tipsandroid.animacion.R;

public class MainActivity extends Activity
{

	private LinearLayout layoutAnimado;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layoutAnimado = (LinearLayout) findViewById(R.id.animado);
	}

	public void mostrar(View button)
	{
		if (layoutAnimado.getVisibility() == View.GONE)
		{
			animar(true);
			layoutAnimado.setVisibility(View.VISIBLE);
		}
	}

	public void ocultar(View button)
	{
		if (layoutAnimado.getVisibility() == View.VISIBLE)
		{
			animar(false);
			layoutAnimado.setVisibility(View.GONE);
		}

	}
	
	private void animar(boolean mostrar)
	{
		AnimationSet set = new AnimationSet(true);
		Animation animation = null;
		if (mostrar)
		{
			//desde la esquina inferior derecha a la superior izquierda
			animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		}
		else
		{    //desde la esquina superior izquierda a la esquina inferior derecha
			 animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
		}
		//duración en milisegundos
		animation.setDuration(500);
		set.addAnimation(animation);
		LayoutAnimationController controller = new LayoutAnimationController(set, 0.25f);

		layoutAnimado.setLayoutAnimation(controller);
		
		layoutAnimado.startAnimation(animation);
	}

}