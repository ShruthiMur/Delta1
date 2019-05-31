package com.example.delta;
    import android.arch.lifecycle.ViewModel;
import android.view.View;

    public class ModelActivity extends ViewModel {

        private int Value=0,Success=0,Failure=0;
        public int getValue()
        {
            return Value;
        }
        public int getSuccess()
        {
            return Success;
        }
        public int getFailure()
        {
            return Failure;
        }
    }

