package com.yanhuan.modernjavainaction.cap07;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * TODO
 *
 * @author : yan
 * -----------------------------------------------------
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private static final long serialVersionUID = -2327367337163955529L;

    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long THRESHOLD = 10000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            //是否为空格
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        final String SENTENCE = String.join("\n", "Midway upon the journey of our life \n", "I found myself within a forest dark, \n", "For the straightforward pathway had been lost. \n", "Ah me! how hard a thing it is to say \n", "What was this forest savage, rough, and stern, \n", "Which in the very thought renews the fear. \n", "So bitter is it, death is little more; \n", "But of the good to treat, which there I found, \n", "Speak will I of the other things I saw there. \n", "I cannot well repeat how there I entered, \n", "So full was I of slumber at the moment \n", "In which I had abandoned the true way.\n");

        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(wordCounterSpliterator, true);
//        System.out.println("Found " + countWords(stream) + " words");
//        Arrays.asList()
//        List<String> strings = new ArrayList<>(List.of("adc", "asd", "qwe"));
//        strings.add("45");
//        strings.replaceAll(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1));
//        System.out.println(strings);
//        strings.removeIf("45"::equals);
//        System.out.println(strings);
//        Map<String, Integer> abc = Map.of("abc", 1, "def", 2);
//        System.out.println(abc);
//        Map<String, Integer> asdf = Map.ofEntries(Map.entry("123", 43),
//                Map.entry("asdf", 12));
//        System.out.println(asdf);
        Map<String, Integer> ageOfFriends = new HashMap<>(Map.ofEntries(Map.entry("c", 20),
                Map.entry("a", 54),
                Map.entry("e", 32)));
//        ageOfFriends.forEach((friend,age)-> System.out.println(friend+":"+age));
//        ageOfFriends.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .forEachOrdered(System.out::println);
//        Integer c = ageOfFriends.getOrDefault("a", 23);
//        System.out.println(c);
//
//        dateToHash.computeIfAbsent(line, ForkJoinSumCalculator::calculateDigest)
//String friend = "tom";
//ageOfFriends.remove("a",53);
//        System.out.println(ageOfFriends);
        Map<String, String> family = Map.ofEntries(Map.entry("Tom", "abc"), Map.entry("jack", "123"));
        Map<String, String> friends = Map.ofEntries(Map.entry("tom", "abc"), Map.entry("jack", "789"));
        HashMap<String, String> everyone = new HashMap<>(family);
        friends.forEach((k, v) -> everyone.merge(k, v, (m1, m2) -> m1 + " & " + m2));
//        System.out.println(everyone);
        HashMap<String, Long> moviesToCount = new HashMap<>();
        String movieName = "james Bond";
        moviesToCount.merge(movieName, 1L, (k, c) -> c + 1L);
        System.out.println(moviesToCount);
        Runnable hello = () -> System.out.println("hello");
        hello.run();

    }

    static HashMap<String, byte[]> dateToHash = new HashMap<>();
    static MessageDigest digest;

    static {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static byte[] calculateDigest(String key) {
        return digest.digest(key.getBytes(StandardCharsets.UTF_8));
    }
}
