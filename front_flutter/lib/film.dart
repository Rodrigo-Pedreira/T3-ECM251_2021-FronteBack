import 'dart:convert';

class Film {
  final int id;
  final String name;
  final String genre;
  final String director;
  final String date;
  Film({
    required this.id,
    required this.name,
    required this.genre,
    required this.director,
    required this.date,
  });

  // Film copyWith({
  //   int? id,
  //   String? name,
  //   String? genre,
  //   String? director,
  //   String? date,
  // }) {
  //   return Film(
  //     id: id ?? this.id,
  //     name: name ?? this.name,
  //     genre: genre ?? this.genre,
  //     director: director ?? this.director,
  //     date: date ?? this.date,
  //   );
  // }

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'genre': genre,
      'director': director,
      'date': date,
    };
  }

  factory Film.fromMap(Map<String, dynamic> map) {
    return Film(
      id: map['id']?.toInt(),
      name: map['name'],
      genre: map['genre'],
      director: map['director'],
      date: map['date'],
    );
  }

  String toJson() => json.encode(toMap());

  factory Film.fromJson(String source) => Film.fromMap(jsonDecode(source));

  static List<Film> listFromJson(String source) {
    List<Film> returnList = [];
    final sourceList = jsonDecode(source);

    if (sourceList is! List) {
      returnList.add(Film.fromJson(source));
      return returnList;
    }

    for (var element in sourceList) {
      returnList.add(Film.fromMap(element));
    }
    return returnList;
  }

  @override
  String toString() {
    return 'Film(id: $id, name: $name, genre: $genre, director: $director, date: $date)';
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;

    return other is Film &&
        other.id == id &&
        other.name == name &&
        other.genre == genre &&
        other.director == director &&
        other.date == date;
  }

  @override
  int get hashCode {
    return id.hashCode ^
        name.hashCode ^
        genre.hashCode ^
        director.hashCode ^
        date.hashCode;
  }
}
