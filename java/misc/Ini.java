package com.dreamsense.ini;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Read in an ini file and store it in a <code>HashMap</code> object
 *
 * <p>Ways to construct this class:</p>
 *
 * <pre>
 *     Ini ini = new Ini().debug(true).load("file.ini");
 *     Ini ini = new Ini().debug(false).load(new File("file.ini"));
 *     Ini ini = new Ini().load(inputStream);
 * </pre>
 */
public class Ini {

    private static final Logger log = Logger.getLogger(Ini.class.getName());
    private boolean debug;

    /**
     * The HashMap where the ini properties are kept
     */
    private final Map<String, Properties> map = new HashMap<>();

    /**
     * Main Constructor
     */
    public Ini() {
        this.debug = false;
    }

    /**
     * Load the ini file from a <code>String</code> filename
     * @param iniFile The file to load
     * @return this
     * @throws IOException if the file can't be loaded
     * @throws Exception if the line is bad
     */
    public Ini load(String iniFile) throws Exception {
        List<String> lines = readFile(iniFile);
        parseIniData(lines);
        return this;
    }

    /**
     * Load the ini file from a <code>File</code>
     * @param iniFile The <code>File</code> object to load from
     * @return this
     * @throws Exception if the file can't be loaded or if the line is bad
     */
    public Ini load(File iniFile) throws Exception {
        List<String> lines = readFile(iniFile.getAbsolutePath());
        parseIniData(lines);
        return this;
    }

    /**
     * Load the ini file from an <code>InputStream</code>
     * @param inputStream The input stream to process
     * @return this
     * @throws Exception if the file can't be loaded or if the line is bad
     */
    public Ini load(InputStream inputStream) throws Exception {
        try (Stream<String> stream =new BufferedReader(new InputStreamReader(inputStream))
                .lines()) {
            List<String> lines = stream.collect(Collectors.toList());
            parseIniData(lines);
        }
        return this;
    }

    /**
     * Process the lines of the ini file
     * @param lines The lines of the ini file
     */
    private void parseIniData(List<String> lines) throws Exception {
        Properties properties = null;

        for (String line : lines) {
            if (line == null || line.trim().isEmpty()) {
                continue;
            }

            line = removeComments(line);

            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("[") && line.endsWith("]")) {
                line = line.replace("[", "").replace("]", "");
                properties = new Properties();
                map.put(line, properties);
            } else if(properties != null && line.contains("=")) {
                final int pos = line.indexOf('=');
                String[] kv = {line.substring(0,pos), line.substring(pos+1)};
                if (kv.length == 2) {
                    properties.put(kv[0].trim(), kv[1].trim());
                } else {
                    if (debug) {
                        log.severe("Invalid line: " + line);
                    }
                    throw new IndexOutOfBoundsException();
                }
            } else {
                if (debug) {
                    log.severe("Invalid line: " + line);
                }
                throw new Exception("Invalid Line: " + line);
            }
        }
    }

    /**
     * Write the ini file to a file
     * @param writer The writer object to write to
     * @throws IOException if there's an error writing to the file
     */
    public void store(Writer writer) throws IOException {
        store0((writer instanceof BufferedWriter)?(BufferedWriter)writer
                : new BufferedWriter(writer));
    }

    /**
     * Write the ini file to a file
     * @param out The stream to write to
     * @throws IOException if there's an error writing to the file
     */
    public void store(OutputStream out) throws IOException {
        store0(new BufferedWriter(new OutputStreamWriter(out)));
    }

    /**
     * Write the ini file to a file
     * @param bw The buffered writer we're writing to
     * @throws IOException if there's an error writing to the file
     */
    private void store0(BufferedWriter bw) throws IOException {
        for (Map.Entry<String, Properties> set : map.entrySet()) {
            bw.write(String.format("[%s]%n", set.getKey()));

            Properties props = set.getValue();

            Enumeration<?> e = props.propertyNames();

            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                bw.write(String.format("%s=%s%n", key, props.getProperty(key)));
            }
            bw.newLine();
        }
        bw.flush();
    }

    /**
     * Removes comments from the line
     * @param line The line to work on
     * @return A trimmed line without comments
     */
    private String removeComments(String line) {
        line = line.trim();

        List<String> commentTags = Arrays.asList(";", "#", "!");

        for (String tag : commentTags) {
            if (line.startsWith(tag)) {
                if (debug) {
                    log.info("Ignoring Comment Line: " + line.substring(line.indexOf(tag)));
                }
                line = line.substring(0, line.indexOf(tag));
            }
        }

        return line.trim();
    }

    /**
     * Read the passed in file
     * @param iniFile The name of the file to parse
     * @return A list of file data
     * @throws IOException if there's a problem reading the file
     */
    private List<String> readFile(String iniFile) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(iniFile))) {
            result = lines.collect(Collectors.toList());
        }
        return result;
    }

    /**
     * Check if the map is empty
     * @return true if there are no entries otherwise false
     */
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    /**
     * Get the size of the map
     * @return The size of the map
     */
    public int size() {
        return this.map.size();
    }

    /**
     * Set debug property, default is false
     * @param debug Is debug on or off
     * @return this
     */
    public Ini debug(boolean debug) {
        this.debug = debug;
        return this;
    }

    /**
     * Return the value of the requested key and property
     * @param key The main key/section of the ini file
     * @param property The property under the key/section
     * @return A property value
     * @throws NullPointerException if the key/section doesn't exist
     */
    public String get(String key, String property) throws NullPointerException {
        return map.get(key).getProperty(property);
    }

    /**
     * Return the value of the requested key and property or the default value
     * @param key The main key/section of the ini file
     * @param property The property under the key/section
     * @param defaultValue The value if the key/property isn't found
     * @return A property value
     */
    public String get(String key, String property, String defaultValue) {
        if (!map.containsKey(key)) {
            return defaultValue;
        }
        return map.get(key).getProperty(property, defaultValue);
    }

    /**
     * Get a boolean value of the requested key and property
     * @param key The main key/section of the ini file
     * @param property The property under the key/section
     * @return True if the property can be parsed as true otherwise false
     */
    public boolean getBoolean(String key, String property) {
        return Boolean.parseBoolean(get(key, property));
    }

    /**
     * Get an int of the requested key and property
     * @param key The main key/section of the ini file
     * @param property The property under the key/section
     * @return An integer value of the property
     * @throws NumberFormatException if the property isn't an int
     */
    public int getInt(String key, String property) throws NumberFormatException {
        return Integer.parseInt(get(key, property));
    }

    /**
     * Get a float of the requested key and property
     * @param key The main key/section of the ini file
     * @param property The property under the key/section
     * @return A float value of the property
     * @throws NumberFormatException if the property can't be converted to a float
     */
    public float getFloat(String key, String property) throws NumberFormatException {
        return Float.parseFloat(get(key, property));
    }

    /**
     * Get a double of the requested key and property
     * @param key The main key/section of the ini file
     * @param property The property under the key/section
     * @return A double value of the property
     * @throws NumberFormatException if the property can't be converted to a double
     */
    public double getDouble(String key, String property) throws NumberFormatException {
        return Double.parseDouble(get(key, property));
    }

    /**
     * Get a string array of the requested key and property
     * @param key The main key/section of the ini file
     * @param property The property under the key/section
     * @param delimiter The delimiting regular expression
     * @return A String array
     */
    public String[] getStringArray(String key, String property, String delimiter) {
        return get(key, property).split(delimiter);
    }

    /**
     * Get an array of ints of the requested key and property
     * @param key The main key/section of the ini file
     * @param property The property under the key/section
     * @param delimiter The delimiting regular expression
     * @return An int array
     * @throws NumberFormatException if the property cannot be parsed as an int
     */
    public int[] getIntArray(String key, String property, String delimiter) throws NumberFormatException {
        return Arrays.stream(get(key, property).split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * Get an array of doubles of the requested key and property
     * @param key The main key/section of the ini file
     * @param property The property under the key/section
     * @param delimiter The delimiting regular expression
     * @return A double array
     * @throws NumberFormatException if the property cannot be parsed as a double
     */
    public double[] getDoubleArray(String key, String property, String delimiter) throws NumberFormatException {
        return Arrays.stream(get(key, property).split(delimiter)).mapToDouble(Double::parseDouble).toArray();
    }
}

