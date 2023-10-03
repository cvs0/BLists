import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BLists {
    public static <T> T getLast(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static <T> void shuffle(List<T> list) {
        Collections.shuffle(list);
    }

    public static void processElements(List<Object> list) {
        for (var element : list) {
            if (element instanceof String str) {
                System.out.println("String: " + str);
            } else if (element instanceof Integer num) {
                System.out.println("Number: " + num);
            } else {
                System.out.println("Unknown type");
            }
        }
    }

    public static <T> List<T> reverse(List<T> list) {
        Collections.reverse(list);
        return list;
    }

    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }

    public static <T extends Comparable<? super T>> boolean isSorted(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T> int indexOf(List<T> list, T element) {
        return list.indexOf(element);
    }

    public static <T> List<T> subList(List<T> list, int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    public static <T> List<T> concatenate(List<T> list1, List<T> list2) {
        List<T> concatenatedList = new java.util.ArrayList<>(List.copyOf(list1));
        concatenatedList.addAll(list2);
        return concatenatedList;
    }

    public static <T> List<T> rotate(List<T> list, int distance) {
        int size = list.size();
        if (size == 0) {
            return list;
        }
        int normalizedDistance = distance % size;
        if (normalizedDistance < 0) {
            normalizedDistance += size;
        }
        Collections.rotate(list, normalizedDistance);
        return list;
    }

    public static <T> T mode(List<T> list) {
        return list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
                .map(java.util.Map.Entry::getKey)
                .orElse(null);
    }

    public static <T> List<List<T>> partition(List<T> list, int size) {
        return Collections.nCopies((int) Math.ceil((double) list.size() / size), size)
                .stream()
                .map(subListSize -> list.subList(0, Math.min(subListSize, list.size())))
                .collect(Collectors.toList());
    }

    public static <T> List<T> swap(List<T> list, int index1, int index2) {
        Collections.swap(list, index1, index2);
        return list;
    }

    public static <T> List<T> removeIf(List<T> list, java.util.function.Predicate<? super T> filter) {
        list.removeIf(filter);
        return list;
    }

    public static List<Integer> sum(List<Integer> list) {
        int result = list.stream().reduce(0, Integer::sum);
        return List.of(result);
    }

    public static <T> List<T> flatten(List<List<T>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static <T, U> List<Pair<T, U>> zip(List<T> list1, List<U> list2) {
        int size = Math.min(list1.size(), list2.size());
        return java.util.stream.IntStream.range(0, size)
                .mapToObj(i -> new Pair<>(list1.get(i), list2.get(i)))
                .collect(Collectors.toList());
    }

    public static <T extends Comparable<? super T>> Optional<T> max(List<T> list) {
        return list.stream().max(Comparable::compareTo);
    }

    public static <T extends Comparable<? super T>> Optional<T> min(List<T> list) {
        return list.stream().min(Comparable::compareTo);
    }

    public static <T> Optional<T> reduce(List<T> list, BinaryOperator<T> operator) {
        return list.stream().reduce(operator);
    }

    public static <T, R> List<R> map(List<T> list, Function<? super T, ? extends R> mapper) {
        return list.stream().map(mapper).collect(Collectors.toList());
    }

    public static <T> List<T> takeWhile(List<T> list, java.util.function.Predicate<? super T> predicate) {
        int lastIndex = list.size();
        for (int i = 0; i < lastIndex; i++) {
            if (!predicate.test(list.get(i))) {
                return list.subList(0, i);
            }
        }
        return list;
    }

    public static <T> List<T> dropWhile(List<T> list, java.util.function.Predicate<? super T> predicate) {
        int lastIndex = list.size();
        for (int i = 0; i < lastIndex; i++) {
            if (!predicate.test(list.get(i))) {
                return list.subList(i, lastIndex);
            }
        }
        return Collections.emptyList();
    }

    public static <T> boolean allMatch(List<T> list, Predicate<? super T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static <T> boolean anyMatch(List<T> list, Predicate<? super T> predicate) {
        return list.stream().anyMatch(predicate);
    }

    public static <T> long countOccurrences(List<T> list, T element) {
        return list.stream().filter(e -> e.equals(element)).count();
    }

    public static <T> int lastIndexOf(List<T> list, T element) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
