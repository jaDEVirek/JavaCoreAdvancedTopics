package ChapterStreamApi.sectionStreamOperations;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

@FunctionalInterface
public interface CurrencyConverter {

    public static void main(String[] args) {
        final CurrencyConverter newCurrency = of(LocalDate.now(), "src/main/resources/currency").from("PLN")
                .to("EUR");
        final double convert = newCurrency.convert(50.0);
        System.out.println(convert);

       BiFunction<Integer,Integer,Integer> add = Integer::sum;
        final Function<Integer, Integer> partial = partial(add, 11);
        System.out.println(partial);
        final Integer apply = partial.apply(Integer.valueOf("15"));
        System.out.println(apply);
    }

    double convert(double amount);

     interface CCBiFunction {
        Double convert(Double amount, String fromCurrency);

        default CurrencyConverter to(String toCurrency) {
            System.out.println("Third ? ");
            return amount -> convert(amount, toCurrency);
        }
    }

    interface TriFunction {
        Double convert(Double amount, String fromCurrency, String toCurrency);

        default CCBiFunction from(String fromCurrency) {
            System.out.println("Second ? ");
            return (amount, toCurrency) -> convert(amount, fromCurrency, toCurrency);
        }
    }

    static TriFunction of(LocalDate date, String pathURL) {
        return (amount, fromCurrency, toCurrency) -> {
            System.out.println(amount + " First! +  val " + fromCurrency + " val " + toCurrency);
            return amount * (Objects.requireNonNull(preperaFileFromPath(pathURL))
                    .get(toCurrency) / Objects.requireNonNull(preperaFileFromPath(pathURL))
                    .get(fromCurrency));
        };
    }

    static Map<String, Double> preperaFileFromPath(String pathURL) {
        Path path = Paths.get(pathURL);
        try (Stream<String> lines = lines(path)) {
            return lines.skip(1)
                    .collect(Collectors.toMap(
                            lineK -> lineK.substring(0, 3),
                            lineV -> Double.valueOf(lineV.substring(4))
                    ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T, U, R> Function<U, R> partial(BiFunction<T, U, R> f, T x) {
        return (y) -> {
            System.out.println(y);
            return f.apply(x, y);
        };
    }
}
