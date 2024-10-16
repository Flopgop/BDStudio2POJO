package net.flamgop;

import java.util.ArrayList;
import java.util.Objects;

public class BDStudio extends BDStudioGenericData {

    public ArrayList<Child> children;
    public boolean isCollection;

    public BDStudio() {}

    public BDStudio(String name, String nbt, ArrayList<Double> transforms, ArrayList<Child> children, boolean isCollection) {
        this.name = name;
        this.nbt = nbt;
        this.transforms = transforms;
        this.children = children;
        this.isCollection = isCollection;
    }

    public static class TextOptions {
        public String color;
        public double alpha;
        public String backgroundColor;
        public double backgroundAlpha;
        public boolean bold;
        public boolean italic;
        public boolean underline;
        public boolean strikeThrough;
        public int lineLength;
        public Align align;

        public TextOptions() {}

        public TextOptions(String color, double alpha, String backgroundColor, double backgroundAlpha, boolean bold, boolean italic,
                       boolean underline, boolean strikeThrough, int lineLength, Align align) {
            this.color = color;
            this.alpha = alpha;
            this.backgroundColor = backgroundColor;
            this.backgroundAlpha = backgroundAlpha;
            this.bold = bold;
            this.italic = italic;
            this.underline = underline;
            this.strikeThrough = strikeThrough;
            this.lineLength = lineLength;
            this.align = align;
        }

        @Override
        public String toString() {
            return "Options{" +
                "color='" + color + '\'' +
                ", alpha=" + alpha +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", backgroundAlpha=" + backgroundAlpha +
                ", bold=" + bold +
                ", italic=" + italic +
                ", underline=" + underline +
                ", strikeThrough=" + strikeThrough +
                ", lineLength=" + lineLength +
                ", align=" + align +
                '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof TextOptions options)) return false;
            return Double.compare(options.alpha, alpha) == 0 &&
                Double.compare(options.backgroundAlpha, backgroundAlpha) == 0 &&
                bold == options.bold &&
                italic == options.italic &&
                underline == options.underline &&
                strikeThrough == options.strikeThrough &&
                lineLength == options.lineLength &&
                Objects.equals(color, options.color) &&
                Objects.equals(backgroundColor, options.backgroundColor) &&
                align == options.align;
        }

        @Override
        public int hashCode() {
            return Objects.hash(color, alpha, backgroundColor, backgroundAlpha, bold, italic, underline, strikeThrough, lineLength, align);
        }
    }

    public enum Align {
        LEFT,
        CENTER,
        RIGHT
    }

    public static class Child extends BDStudioGenericData {
        public boolean isItemDisplay;
        public boolean isTextDisplay;
        public boolean isBlockDisplay;
        public TextOptions options;

        public Child() {}

        public Child(String name, String nbt, ArrayList<Double> transforms, boolean isItemDisplay,
                     boolean isTextDisplay, boolean isBlockDisplay, TextOptions options) {
            this.name = name;
            this.nbt = nbt;
            this.transforms = transforms;
            this.isItemDisplay = isItemDisplay;
            this.isTextDisplay = isTextDisplay;
            this.isBlockDisplay = isBlockDisplay;
            this.options = options;
        }

        @Override
        public String toString() {
            return "Child{" +
                "name='" + name + '\'' +
                ", nbt='" + nbt + '\'' +
                ", transforms=" + transforms +
                ", isItemDisplay=" + isItemDisplay +
                ", isTextDisplay=" + isTextDisplay +
                ", isBlockDisplay=" + isBlockDisplay +
                ", options=" + options +
                '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Child child)) return false;
            return isItemDisplay == child.isItemDisplay &&
                isTextDisplay == child.isTextDisplay &&
                isBlockDisplay == child.isBlockDisplay &&
                Objects.equals(name, child.name) &&
                Objects.equals(nbt, child.nbt) &&
                Objects.equals(transforms, child.transforms) &&
                Objects.equals(options, child.options);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, nbt, transforms, isItemDisplay, isTextDisplay, isBlockDisplay, options);
        }
    }

    @Override
    public String toString() {
        return "BDStudio{" +
            "name='" + name + '\'' +
            ", nbt='" + nbt + '\'' +
            ", transforms=" + transforms +
            ", children=" + children +
            ", isCollection=" + isCollection +
            '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BDStudio bdStudio)) return false;
        return isCollection == bdStudio.isCollection &&
            Objects.equals(name, bdStudio.name) &&
            Objects.equals(nbt, bdStudio.nbt) &&
            Objects.equals(transforms, bdStudio.transforms) &&
            Objects.equals(children, bdStudio.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nbt, transforms, children, isCollection);
    }
}
