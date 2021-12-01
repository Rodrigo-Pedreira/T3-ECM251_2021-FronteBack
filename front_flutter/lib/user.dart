import 'dart:convert';

class User {
  final int id;
  final String name;
  final String password;
  final String email;
  User({
    required this.id,
    required this.name,
    required this.password,
    required this.email,
  });

  // User copyWith({
  //   int? id,
  //   String? name,
  //   String? password,
  //   String? email,
  // }) {
  //   return User(
  //     id: id ?? this.id,
  //     name: name ?? this.name,
  //     password: password ?? this.password,
  //     email: email ?? this.email,
  //   );
  // }

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'password': password,
      'email': email,
    };
  }

  factory User.fromMap(Map<String, dynamic> map) {
    return User(
      id: map['id']?.toInt(),
      name: map['name'],
      password: map['password'],
      email: map['email'],
    );
  }

  String toJson() => json.encode(toMap());

  factory User.fromJson(String source) => User.fromMap(json.decode(source));

  static List<User> listFromJson(String source) {
    List<User> returnList = [];
    final sourceList = jsonDecode(source);

    if (sourceList is! List) {
      returnList.add(User.fromJson(source));
      return returnList;
    }

    for (var element in sourceList) {
      returnList.add(User.fromMap(element));
    }
    return returnList;
  }

  @override
  String toString() {
    return 'User(id: $id, name: $name, password: $password, email: $email)';
  }

  @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;

    return other is User &&
        other.id == id &&
        other.name == name &&
        other.password == password &&
        other.email == email;
  }

  @override
  int get hashCode {
    return id.hashCode ^ name.hashCode ^ password.hashCode ^ email.hashCode;
  }
}
