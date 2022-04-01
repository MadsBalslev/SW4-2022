# Formal semantic specification
## Abstract syntax
### Syntactic categories
$$
\begin{align}
    ri &\in RI - \text{Recipe identifier} \\
    ii &\in II - \text{Ingredient identifier} \\
    ti &\in TI - \text{Tool identifier} \\
    tai &\in TAI - \text{Tool action identifier} \\
    \\
    iti &\in ITI - \text{Ingredient type identifier} \\
    tti &\in TTI - \text{Tool type identifier} \\
    \\
    rd &\in RD - \text{Recipe declaration} \\
    id &\in ID - \text{Ingredient declaration} \\
    td &\in TD - \text{Tool declaration} \\
    \\
    tad &\in TAD - \text{Tool action declaration} \\

\end{align}
$$

### Formation rules
$$
\begin{align}

rd ::= & \; \text{main recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} }   \\ 
\mid & \; \text{recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} }   \\ 
\mid & \; rd_1 \text{ , } rd_2 \\
\mid & \; \epsilon \\

id ::= & \; iti \; ii \; ad \\
\mid & \; iti \; ii \; ad \text{ or } id_1 \\
\mid & \; \text{recipe} \; ii \; \\
\mid & \; iti_1 \; iti_2 \\
\mid & \; id_1 \text{ , } id_2 \\
\mid & \; \epsilon \\

td ::= & \; tti \; ti \text{ [ } tad \text{ ] } \\
\mid & \; td_1 \text{ , } td_2 \\
\mid & \; \epsilon \\

tad ::= & \; tai \text{ : } iti \text{ => } iti \\
\mid & \text{ contain : } iti \\
\mid & \; tai \text{ : content in } ti \text{ => } iti \\
\mid & \; \epsilon \\

sd ::= & \; ti \; \text{ do } tai \; ds \; in \\
\mid & \; ti \; \text{ do } tai \; ds \; in \text{ => } out \\
\mid & \; sd_1 \text{ , } sd_2 \\
\mid & \; \epsilon \\

in ::= & \; ii \mid \text{\{ } ic \text{ \}} \mid \text{content in} \; ti \\

in ::= & \; ii \mid \text{\{ } ic \text{ \}} \\
ic ::= & \; ic_1 \text{ , } ic_2 \mid ii \mid \epsilon


\end{align}
$$
