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
        final TriFunction path = of(LocalDate.now(), "Path");
        final CCBiFunction aThis = path.from("this");

    }

    double convert(double amount);

       public interface CCBiFunction {
            Double convert(Double amount, String fromCurrency);

            default  CurrencyConverter to(String toCurrency){
                return amount -> convert(amount,toCurrency);
            }
        }

     interface TriFunction {
       Double convert(Double amount, String fromCurrency, String toCurrency);

       default CCBiFunction from(String fromCurrency){
           return (amount, toCurrency) -> convert(amount,fromCurrency,toCurrency);
       }
     }

    static TriFunction of(LocalDate date,String pathURL){
        return (amount,fromCurrency,toCurrency) -> {
            return  amount*(Objects.requireNonNull(preperaFileFromPath(pathURL))
                    .get(fromCurrency)/ Objects.requireNonNull(preperaFileFromPath(pathURL))
                    .get(toCurrency));
        };
    }

    static Map<String, Double> preperaFileFromPath(String pathURL){
        Path path = Paths.get(pathURL);
        try(Stream<String> lines = lines(path)){
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
        return (y) -> f.apply(x, y);
    }
}
