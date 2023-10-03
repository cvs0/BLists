import java.util.List;
import java.util.stream.Collectors;

public class TypeConversion {
    public static List<Integer> convertStringListToIntList(List<String> stringList) {
        return stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> convertIntListToStringList(List<Integer> intList) {
        return intList.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public static List<Integer> convertDoubleListToIntList(List<Double> doubleList) {
        return doubleList.stream()
                .map(Double::intValue)
                .collect(Collectors.toList());
    }

    public static List<Double> convertIntListToDoubleList(List<Integer> intList) {
        return intList.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
    }

    public static String convertListToString(List<String> stringList) {
        return String.join(", ", stringList);
    }

    public static <E extends Enum<E>> List<E> convertStringListToEnumList(List<String> stringList, Class<E> enumType) {
        return stringList.stream()
                .map(value -> Enum.valueOf(enumType, value))
                .collect(Collectors.toList());
    }

    public static <T> List<T> convertList(List<?> originalList, Class<T> targetType) {
        return originalList.stream()
                .map(targetType::cast)
                .collect(Collectors.toList());
    }
}
