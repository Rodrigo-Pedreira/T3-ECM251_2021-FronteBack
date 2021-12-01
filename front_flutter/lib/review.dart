import 'dart:convert';

class Review {
  final int id;
  final int idUser;
  final int idFilm;
  final String review;
  final int likes;
  final int score;
  final String date;
  Review({
    required this.id,
    required this.idUser,
    required this.idFilm,
    required this.review,
    required this.likes,
    required this.score,
    required this.date,
  });

  // Review copyWith({
  //   int? id,
  //   int? idUser,
  //   int? idFilm,
  //   String? review,
  //   int? likes,
  //   int? score,
  //   String? date,
  // }) {
  //   return Review(
  //     id: id ?? this.id,
  //     idUser: idUser ?? this.idUser,
  //     idFilm: idFilm ?? this.idFilm,
  //     review: review ?? this.review,
  //     likes: likes ?? this.likes,
  //     score: score ?? this.score,
  //     date: date ?? this.date,
  //   );
  // }

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'idUser': idUser,
      'idFilm': idFilm,
      'review': review,
      'likes': likes,
      'score': score,
      'date': date,
    };
  }

  factory Review.fromMap(Map<String, dynamic> map) {
    return Review(
      id: map['id']?.toInt(),
      idUser: map['idUser']?.toInt(),
      idFilm: map['idFilm']?.toInt(),
      review: map['review'],
      likes: map['likes']?.toInt(),
      score: map['score']?.toInt(),
      date: map['date'],
    );
  }

  String toJson() => jsonEncode(toMap());

  factory Review.fromJson(String source) => Review.fromMap(jsonDecode(source));

  static List<Review> listFromJson(String source) {
    List<Review> returnList = [];
    final sourceList = jsonDecode(source);

    if (sourceList is! List) {
      returnList.add(Review.fromJson(source));
      return returnList;
    }

    for (var element in sourceList) {
      returnList.add(Review.fromMap(element));
    }
    return returnList;
  }

  @override
  String toString() {
    return 'Review(id: $id, idUser: $idUser, idFilm: $idFilm, review: $review, likes: $likes, score: $score, date: $date)';
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;
    //
    return other is Review &&
        other.id == id &&
        other.idUser == idUser &&
        other.idFilm == idFilm &&
        other.review == review &&
        other.likes == likes &&
        other.score == score &&
        other.date == date;
  }

  @override
  int get hashCode {
    return id.hashCode ^
        idUser.hashCode ^
        idFilm.hashCode ^
        review.hashCode ^
        likes.hashCode ^
        score.hashCode ^
        date.hashCode;
  }
}
