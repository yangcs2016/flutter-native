import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child:
          Container(
            child: AndroidView(
              viewType: 'plugin.yangcs/demo',
              // creationParams: {
              //   "myContent": "通过参数传入的文本内容",
              // },
              creationParamsCodec: const StandardMessageCodec(),
              // onPlatformViewCreated: onMyViewCreated,

            ),
            color: Colors.red,
            height: 100.0,
          ),
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.favorite),
        onPressed: () async {
          await setMyViewText("come here");
        },
      ),
    );
  }
  MethodChannel _channel;

  // void onMyViewCreated(int id) {
  //   _channel = new MethodChannel('plugin.yangcs/demo_$id');
  //   setMyViewText("new guy");
  // }

  Future<void> setMyViewText(String text) async {
    assert(text != null);
    print(text);
    return _channel.invokeMethod('setText', text);
  }
}

