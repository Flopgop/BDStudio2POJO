package net.flamgop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BDStudioUtilTest {
    @Test
    @DisplayName("Decompress an example compressed and encoded BDStudio string")
    void decompress() {
        BDStudio bd = BDStudioUtil.bdStudio2POJO("H4sIAAAAAAAACoWSTWvEIBCG/0qZXt1gEs0aYQ/9uBR6KLS3sBRXTWLX6GIMtJT970Xa0I/NUr3ozDszzwzTvIMZb7y1WkbjHfAYJo3AiUEDh4fgX7SMgMDtInAABDEIN7Y+DCPwJkf46y6+tghkb6wK2gFvUqVr6+X+1owHK97+1NpZMcbndgpOSN20QhrXbUY/xR5ZEzdJuz0LgrOCMpbXmNAcF7TAdYUwWuGsrmhdUFZUBatxxcqfiIvOxURzP0eUmriLeljuQUghjXjeTTF616hPzaY1r1qdZ1+d1FyTs3hf7MudLWZa5X/wn/RrXMZ/9IO+SO4LOwgPCPwhLcUI/B2ktz4Ah8u6JIooQCDsoRfAccYQ7ITcd8FPTt3MOlZTRZPu23c1R1CcYrxVM4CJwho5/yandLDG6dkwxmD2+qkPfur62ZgE99p1sQdO88RjOgccrG4jHP9fWZyR+tep1ghnrKpwQQku14yQklGUZ6Rc08/pnjgXc3zPe3vcfgA5Ek8aYQMAAA==");

        BDStudio expectedOutput = new BDStudio();
        expectedOutput.name = "Project";
        expectedOutput.nbt = "";
        expectedOutput.transforms = new ArrayList<>(){{
            addAll(List.of(
                1, 0, 0, 0,
                    0, 1, 0, 0,
                    0, 0, 1, 0,
                    0, 0, 0, 1));
        }};

        ArrayList<BDStudio.Child> children = new ArrayList<>();
        children.add(new BDStudio.Child("blast_furnace[facing=south,lit=true]", "",
            new ArrayList<>(){{
                addAll(List.of(0.25881904510252096, 0.0, -0.9659258262890683, 0.0,
                0.0, 1.0, 0.0, 0.0,
                0.9659258262890683, 0.0, 0.25881904510252096, 0.0,
                0.0, 0.0, 0.0, 1.0));
            }},
            false, false, true, null));

        children.add(new BDStudio.Child("acacia_button[display=fixed]", "",
            new ArrayList<>(){{
                addAll(List.of(-0.25881904510252074, 0.0, 0.9659258262890683, 0.0,
                0.0, 1.0, 0.0, 0.0,
                -0.9659258262890683, 0.0, -0.25881904510252074, -1.0,
                0.0, 0.0, 0.0, 1.0));
            }},
            true, false, false, null));

        children.add(new BDStudio.Child("Some Text lmao", "",
            new ArrayList<>(){{
                addAll(List.of(1.0, 0.0, 0.0, 0.0,
                0.0, 0.49999999999999967, 0.8660254037844385, 1.4375,
                0.0, -0.8660254037844385, 0.49999999999999967, 0.0,
                0.0, 0.0, 0.0, 1.0));
            }},
            false, true, false,
            new BDStudio.Options("#934d4d", 0.8, "#895d5d", 0.508,
                true, true, true, true, 51, null)));

        expectedOutput.children = children;
        expectedOutput.isCollection = true;

        assertEquals(bd, expectedOutput, "Deserialized BDStudio did not match expected output! Format may have updated.");
    }
}