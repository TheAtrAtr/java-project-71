### Hexlet tests and linter status:
[![Actions Status](https://github.com/TheAtrAtr/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/TheAtrAtr/java-project-71/actions)
[![Java CI](https://github.com/TheAtrAtr/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/TheAtrAtr/java-project-71/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/254f63e0ad7ebb157a6a/maintainability)](https://codeclimate.com/github/TheAtrAtr/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/254f63e0ad7ebb157a6a/test_coverage)](https://codeclimate.com/github/TheAtrAtr/java-project-71/test_coverage)

[Демонстрация сравнения файлов формата JSON и YML (форматы результатов вывода: stylish, plain, json)](https://asciinema.org/a/5DIDxv1rmDeHZQnt6UKIxWr15)

Программа для поиска различий между данными в двух файлах.
Для входных файлов поддерживаются форматы — json и yaml.
Вывод отличий возможен в разных версиях — plain, stylish, json.

Usage: gendiff [-hV] [-f=format] filepath1 filepath2
Compares two configuration files and shows a difference.
filepath1         path to first file
filepath2         path to second file
-f, --format=format   output format [default: stylish]
-h, --help            Show this help message and exit.
-V, --version         Print version information and exit.