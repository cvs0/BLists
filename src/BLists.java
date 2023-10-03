import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static <T> List<T> concatenateLists(List<T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    public static <T, U> List<Pair<T, U>> mergeLists(List<T> list1, List<U> list2) {
        int size = Math.min(list1.size(), list2.size());
        List<Pair<T, U>> mergedList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            mergedList.add(new Pair<>(list1.get(i), list2.get(i)));
        }
        return mergedList;
    }

    public static <T> List<T> swapElements(List<T> list, int index1, int index2) {
        Collections.swap(list, index1, index2);
        return list;
    }

    public static <T> List<T> rotateLeft(List<T> list, int distance) {
        Collections.rotate(list, -distance);
        return list;
    }

    public static <T> List<T> rotateRight(List<T> list, int distance) {
        Collections.rotate(list, distance);
        return list;
    }

    public static int sumOfSquaresOfEvens(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
    }

    public static double averageLengthOfStringsStartingWithPrefix(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(prefix))
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
    }

    public static List<List<String>> groupStringsByLength(List<String> strings) {
        return new ArrayList<>(strings.stream()
                .collect(Collectors.groupingBy(String::length))
                .values());
    }

    public static long productOfSquaredOdds(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToLong(n -> (long) n * n)
                .reduce(1, (a, b) -> a * b);
    }

    public static <T> T mostCommonElement(List<T> list) {
        Map<T, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        return frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static <T> Map<Boolean, List<T>> partitionList(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .collect(Collectors.partitioningBy(predicate));
    }

    public static <T, R> List<R> customOperationOnAdjacentPairs(List<T> list, BiFunction<T, T, R> operation) {
        return IntStream.range(0, list.size() - 1)
                .mapToObj(i -> operation.apply(list.get(i), list.get(i + 1)))
                .collect(Collectors.toList());
    }

    public static <T> List<List<T>> transposeMatrix(List<List<T>> matrix) {
        return new ArrayList<>(matrix.stream()
                .flatMap(i -> IntStream.range(0, i.size())
                        .mapToObj(j -> new Pair<>(j, i.get(j))))
                .collect(Collectors.groupingBy(Pair::first,
                        LinkedHashMap::new,
                        Collectors.mapping(Pair::second, Collectors.toList())))
                .values());
    }

    public static String wordWithHighestAsciiSum(List<String> words) {
        return words.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        word -> word.chars().sum()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private static boolean hasCycleUtil(String node, Map<String, List<String>> graph,
                                        Set<String> visited, Set<String> recStack) {
        if (!visited.contains(node)) {
            visited.add(node);
            recStack.add(node);

            List<String> neighbors = graph.getOrDefault(node, Collections.emptyList());
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor) && hasCycleUtil(neighbor, graph, visited, recStack)) {
                    return true;
                } else if (recStack.contains(neighbor)) {
                    return true;
                }
            }
        }

        recStack.remove(node);
        return false;
    }

    public static boolean hasCycle(List<Pair<String, String>> edges) {
        Map<String, List<String>> graph = edges.stream()
                .collect(Collectors.groupingBy(Pair::first,
                        Collectors.mapping(Pair::second, Collectors.toList())));

        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();

        for (String node : graph.keySet()) {
            if (hasCycleUtil(node, graph, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    public static double jaccardSimilarity(List<String> list1, List<String> list2) {
        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        return (double) intersection.size() / union.size();
    }

    public static String mostFrequentNGram(List<String> words, int n) {
        return words.stream()
                .flatMap(word -> IntStream.range(0, word.length() - n + 1)
                        .mapToObj(i -> word.substring(i, i + n)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static double median(List<Integer> numbers) {
        List<Integer> sortedList = numbers.stream()
                .sorted()
                .toList();

        int size = sortedList.size();
        if (size % 2 == 0) {
            int mid1 = sortedList.get(size / 2 - 1);
            int mid2 = sortedList.get(size / 2);
            return (double) (mid1 + mid2) / 2;
        } else {
            return sortedList.get(size / 2);
        }
    }

    public static String longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = s1.length();
        int j = s2.length();
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }

    public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int[][] result = new int[n][n];

        IntStream.range(0, n).parallel().forEach(i ->
                IntStream.range(0, n).forEach(j ->
                        result[i][j] = IntStream.range(0, n)
                                .map(k -> matrix1[i][k] * matrix2[k][j])
                                .sum()
                )
        );

        return result;
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));

        return result;
    }

    public static <T extends Comparable<T>> List<T> parallelMergeSort(List<T> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<T> left = list.subList(0, mid);
        List<T> right = list.subList(mid, list.size());

        List<T> sortedLeft = parallelMergeSort(left);
        List<T> sortedRight = parallelMergeSort(right);

        return merge(sortedLeft, sortedRight);
    }

    public static <T> List<T> kMostFrequentElements(List<T> list, int k) {
        Map<T, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<T, Long>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Double> movingAverage(List<Double> numbers, int windowSize) {
        if (windowSize <= 0 || windowSize > numbers.size()) {
            throw new IllegalArgumentException("Invalid window size");
        }

        List<Double> averages = new ArrayList<>();
        double sum = 0;

        for (int i = 0; i < windowSize; i++) {
            sum += numbers.get(i);
        }

        averages.add(sum / windowSize);

        for (int i = windowSize; i < numbers.size(); i++) {
            sum += numbers.get(i) - numbers.get(i - windowSize);
            averages.add(sum / windowSize);
        }

        return averages;
    }

    public static <T, R> List<R> filterAndTransform(List<T> list, Predicate<T> filter, Function<T, R> transformer) {
        return list.stream()
                .filter(filter)
                .map(transformer)
                .collect(Collectors.toList());
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> list, Function<T, K> classifier) {
        return list.stream()
                .collect(Collectors.groupingBy(classifier));
    }

    public static <T> List<T> topKElements(List<T> list, int k, Comparator<T> comparator) {
        return list.stream()
                .sorted(comparator.reversed())
                .limit(k)
                .collect(Collectors.toList());
    }
}
