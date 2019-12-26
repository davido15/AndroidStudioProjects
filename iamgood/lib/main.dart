import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.amberAccent,
        appBar: AppBar(
          title:Text('helo world'),
          backgroundColor: Colors.blueGrey[900],
          centerTitle:bool.fromEnvironment('true')
        ),
        body: Center(
          child: Image(
            image: NetworkImage('https://ichef.bbci.co.uk/childrens-responsive-ichef-live/r/720/1x/cbbc/bp-teddy-bear-quiz2.jpg'),
      ),
        ),
    ),
    )
    );

}