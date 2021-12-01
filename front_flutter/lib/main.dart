import 'package:flutter/material.dart';

import 'network_helper.dart';
import 'film.dart';
import 'our_web_adresses.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Lista de filmes', // Aparece como o nome da tab no navegador.
      home: FilmList(), // Pagina web, Lista dos Filmes.
    );
  }
}

/// Exibe um *titulo* e uma **lista com todos os Filmes**, alem de buscar os filmes (**http get**).
class FilmList extends StatefulWidget {
  const FilmList({Key? key}) : super(key: key);

  @override
  _FilmListState createState() => _FilmListState();
}

class _FilmListState extends State<FilmList> {
  /// A *String* nao formatada(json) dos objetos filmes obtidos(http get).
  Future? _filmRequestBody;

  /// A **Lista** de todos os **filmes** obtidos.
  final _filmlist = <Film>[];

  /* Lista de filmes para testes.
  
  final _filmlist = <Film>[
    Film(
        id: 1,
        name: "name",
        genre: "genre",
        director: "director",
        date: "date"),
    Film(
        id: 2,
        name: "name2",
        genre: "genre",
        director: "director2",
        date: "date")
  ]; */

  /// Executa so uma vez, quando a pagina carrega. Busca e cria a Lista com todos os filmes.
  @override
  void initState() {
    super.initState();

    // Fazendo HTTP GET, dando parse na resposta e prenchendo a lista de filmes.
    _filmRequestBody =
        Networkhelper.getDataBody(OurWebAdresses.filmRepositoryURL);

    // Prenche a lista de filmes (apos esperar resposta http).
    _filmRequestBody
        ?.then((value) => _filmlist.addAll(Film.listFromJson(value)));
    /*  .catchError((error) => handleError(error)); 
       Pode tratar erros (agora esta erros sao tratados por um if em _buildFutureList). */
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Lista Filmes"), // Titulo da pagina.
      ),
      body:
          _buildFutureList(), // Corpo da pagina, exibe a Lista de todos os Filmes.

      /* Um botao, ainda pode ser usado para testes se mudar o body tambem.

      floatingActionButton: FloatingActionButton(
        onPressed: _requestFilmList,
        tooltip: 'Load Film List',
        child: const Icon(Icons.add),
      ), */
    );
  }

  /// Exibe a Lista de todos os Filmes ou erro ou icone de carregando.
  Widget _buildFutureList() {
    return FutureBuilder(
      future: _filmRequestBody,
      builder: (ctx, snapshot) {
        if (snapshot.hasData) {
          return _buildFilmList(); // Controi a Lista dos filmes.
        } else if (snapshot.hasError) {
          return const Text("HTTP GET Failed"); // Indica erro.
        } else {
          // Mostra um Icone de carregamento e Texto no centro (display antes do future acabar).
          return Center(
              child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: const <Widget>[
                SizedBox(
                  child: CircularProgressIndicator(),
                  width: 60,
                  height: 60,
                ),
                Padding(
                  padding: EdgeInsets.only(top: 16),
                  child: Text('Awaiting results...'),
                )
              ]));
        }
      },
    );
  }

/* Funcao teste antiga usada em conjunto com o floating button para adicionar os filmes na lista.

  void _requestFilmList() {
    Future filmRequest = Networkhelper.getData(Networkhelper.filmRepositoryURL);
    filmRequest.then((value) {
      final parsedList = Film.listFromJson(value);
      setState(() {
        _filmlist.addAll(parsedList);
      });
    });
  }
*/

  /// Constroi a Lista dos filmes (nome e diretor).
  Widget _buildFilmList() {
    return ListView.builder(
        padding: const EdgeInsets.all(16),
        itemCount: _filmlist.length, // Tamanho da lista.
        itemBuilder: (BuildContext _contex, int i) {
          return ListTile(
            title: Text(_filmlist[i].name), // Nome do filme.
            subtitle: Text(_filmlist[i].director), //  Diretor do filme.
          );
        });
  }
}
