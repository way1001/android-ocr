package com.rw.zx.androidocr;

import android.os.Bundle;
import android.view.View;

import org.devio.takephoto.app.TakePhotoFragment;

public class CameraFragment extends TakePhotoFragment {
    private CustomHelper customHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_layout, null);
        customHelper = CustomHelper.of(view);
        return view;
    }

    public void onClick(View view) {
        customHelper.onClick(view, getTakePhoto());
    }


    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        showImg(result.getImages());
    }

    private void showImg(ArrayList<TImage> images) {
        Intent intent = new Intent(getContext(), ResultActivity.class);
        intent.putExtra("images", images);
        startActivity(intent);
    }
}
