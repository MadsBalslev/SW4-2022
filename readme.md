# 4th Semester project, BSc Software AAU - Fannie

<div id="top"></div>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]


<h3 align="center">Fannie - A Recipe Language Specification</h3>

  <p align="center">
    The goal of this recipe specification language is to give authors, programmers and home cooks a tool for writing good and correct recipes.
    No more missing or misused ingredients or tools throught the recipe.
    Fannie will help you keep track of it all, while giving you the opportunity of writing flavorful descriptions to the steps in your recipe. 
    <br />
    <a href="https://github.com/MadsBalslev/SW4-2022"><strong>Explore the docs »</strong></a>
    <br />
    <br />
  </p>
</div>


<!-- ABOUT THE PROJECT -->
## About The Project

### Purpose
That the student learns how to design and implement a programming language and how this process can be supported by formal definitions of the language's syntax and semantics and techniques and methods for translator and / or interpreter construction.

### Reason

All software is written in a programming language and is translated or interpreted in order to be executed. Design, description and construction of Programming languages, translators, interpreters and similar tools are therefore central topics in computer science.

Therefore, the project work focuses on ensuring that the students understand important underlying concepts in the world of programming languages, why these concepts have arisen and how they are formally described and represented in an implementation. Understanding these topics is fundamental in understanding new and existing programming languages and their applications.

Furthermore, many techniques and tools, originally developed for languages and translators, are also used in other contexts in program development.


<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [ANTLR 4.9.3](https://www.antlr.org/download.html)
* [Apache Maven 3.8.5](https://maven.apache.org/download.cgi)
* [JUnit 4.13.1](https://mvnrepository.com/artifact/junit/junit/4.13.1)

<p>(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you could start setting up your project locally.
To get a local copy up and running follow these simple example steps.



### Installation

1. Clone the repo:
   ```sh
   git clone https://github.com/MadsBalslev/SW4-2022.git
   ```
2. Then `cd` into `fannie-compiler` and run:
   ```sh
   mvn clean install
   ```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage
After the installation is done, you can now begin writing recipes in the fannie language!

First create a file with the ending `.fannie`.

Afterwards open up the `pom.xml` file, which is located under the `fannie-compiler` folder.
In there you should navigate to 
```xml
<arguments>
    <argument>../RecipeExamples/Pasta.fannie</argument>
</arguments> 
```

and change the path to your own recipe.

When you want to compile the recipe, simply type `mvn exec:java` into your terminal, and watch it compile.

And success!
You have now created a good and correct recipe, which got converted into three formats for you to use.

Bone apple tea!

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact
Project Link: [https://github.com/MadsBalslev/SW4-2022](https://github.com/MadsBalslev/SW4-2022)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments
### Guidance
* Sean Kauffman

### Development
* [Simon M. P. Andersen](https://github.com/uglenDX)
* [Nicolai Bruun Nielsen](https://github.com/Mightyhaha)
* [Casper Ståhl](https://github.com/CasperStaahl)
* [Patrick Bertelsen](https://github.com/pberte20)
* [Lukas Juel Jakobsen](https://github.com/lugialukas)
* [Mads P. Balslev](https://github.com/MadsBalslev)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/MadsBalslev/SW4-2022.svg?style=for-the-badge
[contributors-url]: https://github.com/MadsBalslev/SW4-2022/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/MadsBalslev/SW4-2022.svg?style=for-the-badge
[forks-url]: https://github.com/MadsBalslev/SW4-2022/network/members
[stars-shield]: https://img.shields.io/github/stars/MadsBalslev/SW4-2022.svg?style=for-the-badge
[stars-url]: https://github.com/MadsBalslev/SW4-2022/stargazers
[issues-shield]: https://img.shields.io/github/issues/MadsBalslev/SW4-2022.svg?style=for-the-badge
[issues-url]: https://github.com/MadsBalslev/SW4-2022/issues
[license-shield]: https://img.shields.io/github/license/MadsBalslev/SW4-2022.svg?style=for-the-badge
[license-url]: https://github.com/MadsBalslev/SW4-2022/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
