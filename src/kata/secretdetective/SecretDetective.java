package kata.secretdetective;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SecretDetective {

    public String recoverSecret(char[][] triplets) {
        return buildSecret(toList(triplets), new StringBuilder());
    }

    private String buildSecret(
            List<List<Character>> tripletsString, StringBuilder stringBuilder) {
        final Set<Character> firstChars = tripletsString.stream().map(x-> {
            if(x.isEmpty()) return null; else return x.get(0);
        }).filter(Objects::nonNull).collect(Collectors.toSet());
        final Set<Character> exceptFirstChars =
                tripletsString.stream().map(List::stream)
                        .flatMap(stream-> stream.skip(1))
                        .filter(Objects::nonNull)
                        .collect(Collectors.toSet());
        firstChars.removeAll(exceptFirstChars);
        final Optional<Character> firstCharFound =  firstChars.stream().findFirst();
        if (firstCharFound.isEmpty()) {
            return stringBuilder.toString();
        } else {
            tripletsString.forEach(x -> x.remove(firstCharFound.get()));
            stringBuilder.append(firstCharFound.get());
            return buildSecret(tripletsString, stringBuilder);
        }
    }

    private List<List<Character>> toList(char[][] triplets) {
        final List<List<Character>> tripletsString = new ArrayList<>();
        Arrays.stream(triplets).forEach(triplet -> tripletsString.add(toArrayList(triplet)));
        return tripletsString;
    }

    private List<Character> toArrayList(char[] triplet) {
        final List<Character> list = new ArrayList<>();
        for (char c : triplet) {
            list.add(c);
        }
        return list;
    }

}
