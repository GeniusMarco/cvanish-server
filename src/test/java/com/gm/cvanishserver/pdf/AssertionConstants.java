package com.gm.cvanishserver.pdf;

public class AssertionConstants {
    public static final String EXPECTED_REQUIRED_FIELDS_ONLY = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
            "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
            "\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n" +
            "\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
            "\n" +
            "    <title>John Doe - CV</title>\n" +
            "\n" +
            "    <style type=\"text/css\">\n" +
            "        @font-face {\n" +
            "            font-family: Lato;\n" +
            "            src: url(classpath:fonts/Lato-Regular.ttf);\n" +
            "        }\n" +
            "        @font-face {\n" +
            "            font-family: Lato;\n" +
            "            src: url(classpath:fonts/Lato-Bold.ttf);\n" +
            "            font-weight: bold;\n" +
            "        }\n" +
            "        @font-face {\n" +
            "            font-family: Lato;\n" +
            "            src: url(classpath:fonts/Lato-Italic.ttf);\n" +
            "            font-style: italic;\n" +
            "        }\n" +
            "        * { margin: 0; padding: 0; }\n" +
            "        body { font: 16px Lato, Sans-Serif; line-height: 24px; }\n" +
            "        .clear { clear: both; }\n" +
            "        #page-wrap { width: 700px; margin: 40px auto 10px; }\n" +
            "        h1 { margin: 0 16px 16px 0; padding: 0 16px 16px 0; font-size: 42px; font-weight: bold; letter-spacing: -2px; border-bottom: 1px solid #999; }\n" +
            "        h2 { font-size: 20px; margin: 0 0 6px 0; position: relative; }\n" +
            "        .subtitle {font-size: 16px; font-weight: normal; }\n" +
            "        p { margin: 0 0 16px 0; }\n" +
            "        a { text-decoration: none; border-bottom: 1px dotted #999; }\n" +
            "        a:hover { border-bottom-style: solid; color: black; }\n" +
            "        ul { margin: 0 0 32px 17px; }\n" +
            "        #summary { width: 500px; float: left; }\n" +
            "        #summary p { font-style: italic; color: #666; text-align: justify }\n" +
            "        dt { font-style: italic; font-weight: bold; font-size: 18px; text-align: right; padding: 0 26px 16px 0; width: 100px; float: left; }\n" +
            "        dd { width: 550px; float: none; margin-left: 130px; }\n" +
            "        dd.clear { float: none; margin: 0; height: 15px; }\n" +
            "        .link { color: blue }\n" +
            "        #footer p { font-size: 10px; float:left; font-style: italic; color: #666; text-align: justify }\n" +
            "        .experience, .education, .project, .links{ margin-bottom: 10px; page-break-inside: avoid }\n" +
            "        .bold { font-weight: bold; }\n" +
            "        .justified { text-align: justify }\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "\n" +
            "<div id=\"page-wrap\">\n" +
            "\n" +
            "    <div id=\"contact-info\" class=\"vcard\">\n" +
            "\n" +
            "        <!-- Microformats! -->\n" +
            "\n" +
            "        <h1 class=\"fn\">John Doe</h1>\n" +
            "\n" +
            "        <p>\n" +
            "            <span class=\"bold\">Phone number:</span> <span class=\"tel\">123456789</span><br/>\n" +
            "            <span class=\"bold\">Email address:</span> <a class=\"link\" href=\"mailto:email@address.com\">email@address.com</a>\n" +
            "        </p>\n" +
            "    </div>\n" +
            "\n" +
            "    \n" +
            "\n" +
            "    <dl>\n" +
            "        <dd class=\"clear\"></dd>\n" +
            "\n" +
            "        \n" +
            "\n" +
            "        <dd class=\"clear\" style=\"height: 5px\"></dd>\n" +
            "\n" +
            "        \n" +
            "\n" +
            "        <dd class=\"clear\" style=\"height: 5px\"></dd>\n" +
            "\n" +
            "        \n" +
            "\n" +
            "        <dd class=\"clear\" style=\"height: 5px\"></dd>\n" +
            "\n" +
            "        \n" +
            "\n" +
            "        <dd class=\"clear\"></dd>\n" +
            "\n" +
            "        \n" +
            "\n" +
            "        <dd class=\"clear\"></dd>\n" +
            "    </dl>\n" +
            "\n" +
            "    <div class=\"clear\"></div>\n" +
            "\n" +
            "    <div id=\"footer\">\n" +
            "        <p>Wyrażam zgodę na przetwarzanie moich danych osobowych dla potrzeb niezbędnych do realizacji procesu\n" +
            "            rekrutacji (zgodnie z ustawą z dnia 10 maja 2018 roku o ochronie danych osobowych (Dz. Ustaw z 2018, poz.\n" +
            "            1000) oraz zgodnie z Rozporządzeniem Parlamentu Europejskiego i Rady (UE) 2016/679 z dnia 27 kwietnia 2016\n" +
            "            r. w sprawie ochrony osób fizycznych w związku z przetwarzaniem danych osobowych i w sprawie swobodnego\n" +
            "            przepływu takich danych oraz uchylenia dyrektywy 95/46/WE (RODO).</p>\n" +
            "    </div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";

    public static final String EXPECTED_ALL_FIELDS = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
            "        \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
            "\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\n" +
            "\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
            "\n" +
            "    <title>John Doe - CV</title>\n" +
            "\n" +
            "    <style type=\"text/css\">\n" +
            "        @font-face {\n" +
            "            font-family: Lato;\n" +
            "            src: url(classpath:fonts/Lato-Regular.ttf);\n" +
            "        }\n" +
            "        @font-face {\n" +
            "            font-family: Lato;\n" +
            "            src: url(classpath:fonts/Lato-Bold.ttf);\n" +
            "            font-weight: bold;\n" +
            "        }\n" +
            "        @font-face {\n" +
            "            font-family: Lato;\n" +
            "            src: url(classpath:fonts/Lato-Italic.ttf);\n" +
            "            font-style: italic;\n" +
            "        }\n" +
            "        * { margin: 0; padding: 0; }\n" +
            "        body { font: 16px Lato, Sans-Serif; line-height: 24px; }\n" +
            "        .clear { clear: both; }\n" +
            "        #page-wrap { width: 700px; margin: 40px auto 10px; }\n" +
            "        h1 { margin: 0 16px 16px 0; padding: 0 16px 16px 0; font-size: 42px; font-weight: bold; letter-spacing: -2px; border-bottom: 1px solid #999; }\n" +
            "        h2 { font-size: 20px; margin: 0 0 6px 0; position: relative; }\n" +
            "        .subtitle {font-size: 16px; font-weight: normal; }\n" +
            "        p { margin: 0 0 16px 0; }\n" +
            "        a { text-decoration: none; border-bottom: 1px dotted #999; }\n" +
            "        a:hover { border-bottom-style: solid; color: black; }\n" +
            "        ul { margin: 0 0 32px 17px; }\n" +
            "        #summary { width: 500px; float: left; }\n" +
            "        #summary p { font-style: italic; color: #666; text-align: justify }\n" +
            "        dt { font-style: italic; font-weight: bold; font-size: 18px; text-align: right; padding: 0 26px 16px 0; width: 100px; float: left; }\n" +
            "        dd { width: 550px; float: none; margin-left: 130px; }\n" +
            "        dd.clear { float: none; margin: 0; height: 15px; }\n" +
            "        .link { color: blue }\n" +
            "        #footer p { font-size: 10px; float:left; font-style: italic; color: #666; text-align: justify }\n" +
            "        .experience, .education, .project, .links{ margin-bottom: 10px; page-break-inside: avoid }\n" +
            "        .bold { font-weight: bold; }\n" +
            "        .justified { text-align: justify }\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "\n" +
            "<div id=\"page-wrap\">\n" +
            "\n" +
            "    <div id=\"contact-info\" class=\"vcard\">\n" +
            "\n" +
            "        <!-- Microformats! -->\n" +
            "\n" +
            "        <h1 class=\"fn\">John Doe</h1>\n" +
            "\n" +
            "        <p>\n" +
            "            <span class=\"bold\">Phone number:</span> <span class=\"tel\">123456789</span><br/>\n" +
            "            <span class=\"bold\">Email address:</span> <a class=\"link\" href=\"mailto:email@address.com\">email@address.com</a>\n" +
            "        </p>\n" +
            "    </div>\n" +
            "\n" +
            "    <div id=\"summary\"><p>Summary text</p></div><div class=\"clear\"></div>\n" +
            "\n" +
            "    <dl>\n" +
            "        <dd class=\"clear\"></dd>\n" +
            "\n" +
            "        <dt>Experience</dt><dd><div class=\"experience\"><h2>Developer (2020&nbsp;—&nbsp;Present)</h2><span class=\"subtitle\">Company, New York, USA</span></div></dd>\n" +
            "\n" +
            "        <dd class=\"clear\" style=\"height: 5px\"></dd>\n" +
            "\n" +
            "        <dt>Projects</dt><dd><div class=\"project\"><h2>Project title (2019&nbsp;—&nbsp;2020)</h2><div style=\"margin-bottom: 10px\"><div><span class=\"subtitle\">Link name:</span> <span class=\"link\"><a href=\"google.com\">google.com</a></span></div></div><div class=\"justified\">Project description</div></div></dd>\n" +
            "\n" +
            "        <dd class=\"clear\" style=\"height: 5px\"></dd>\n" +
            "\n" +
            "        <dt>Education</dt><dd><div class=\"education\"><h2>Computer Science, BSc (01-2000&nbsp;—&nbsp;12-2002)</h2><span class=\"subtitle\">MIT, Cambridge, USA</span></div></dd>\n" +
            "\n" +
            "        <dd class=\"clear\" style=\"height: 5px\"></dd>\n" +
            "\n" +
            "        <dt>Skills</dt><dd>Java, Spring Boot</dd>\n" +
            "\n" +
            "        <dd class=\"clear\"></dd>\n" +
            "\n" +
            "        <dt>Links</dt><dd><div class=\"links\"><span class=\"link\"><a href=\"www.google.com\">www.google.com</a></span></div></dd>\n" +
            "\n" +
            "        <dd class=\"clear\"></dd>\n" +
            "    </dl>\n" +
            "\n" +
            "    <div class=\"clear\"></div>\n" +
            "\n" +
            "    <div id=\"footer\">\n" +
            "        <p>Wyrażam zgodę na przetwarzanie moich danych osobowych dla potrzeb niezbędnych do realizacji procesu\n" +
            "            rekrutacji (zgodnie z ustawą z dnia 10 maja 2018 roku o ochronie danych osobowych (Dz. Ustaw z 2018, poz.\n" +
            "            1000) oraz zgodnie z Rozporządzeniem Parlamentu Europejskiego i Rady (UE) 2016/679 z dnia 27 kwietnia 2016\n" +
            "            r. w sprawie ochrony osób fizycznych w związku z przetwarzaniem danych osobowych i w sprawie swobodnego\n" +
            "            przepływu takich danych oraz uchylenia dyrektywy 95/46/WE (RODO).</p>\n" +
            "    </div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";
}
