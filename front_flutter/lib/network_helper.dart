import 'package:http/http.dart' as http;

class Networkhelper {
  static Future getDataBody(url) async {
    http.Response response = await http.get(Uri.parse(url));
    if (response.statusCode == 200) {
      // print(response.statusCode);
      return response.body;
    } else {
      throw Exception(
          'Http Get ERROR:${response.statusCode}: ${response.reasonPhrase}');
    }
  }
}
