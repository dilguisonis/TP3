package edu.ort.ar.juego;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import javax.xml.transform.Source;

/**
 * Created by 41823413 on 21/6/2016.
 */
public class CustomButton extends ImageButton{
    boolean lolazo = Math.random() < 0.5;

    public CustomButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.lolazo = this.lolazo;
        elegir();
    }

    private void elegir()
    {
        if (lolazo == true)
        {
            this.setImageResource(R.drawable.chicha);
        }
        else if(lolazo == false)
        {
            this.setImageResource(R.drawable.shrek);
        }
    }

    public void reset()
    {
       lolazo = Math.random() < 0.5;
        flip();
    }

    public void flip()
    {
        if (lolazo == true)
        {
            this.setImageResource(R.drawable.chicha);
            lolazo = false;
        }
        else if(lolazo == false)
        {
            this.setImageResource(R.drawable.shrek);
            lolazo = true;
        }
    }


}
