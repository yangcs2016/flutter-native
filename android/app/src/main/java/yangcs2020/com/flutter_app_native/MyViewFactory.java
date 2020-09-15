package yangcs2020.com.flutter_app_native;

import android.content.Context;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class MyViewFactory extends PlatformViewFactory {
    private final BinaryMessenger messenger;

    public MyViewFactory(BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = messenger;
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        Map<String,Object> params = (Map<String, Object>) args;
        return new MyView(context,messenger,viewId,params);
    }
}
