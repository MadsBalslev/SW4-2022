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
    ad &\in AD - \text{Amount declaration} \\
    td &\in TD - \text{Tool declaration} \\
    tad &\in TAD - \text{Tool action declaration} \\
    sd &\in SD - \text{step declaration} \\
    \\
    ds &\in DS - \text{Description string} \\
    in &\in IN - \text{Step input} \\
    out &\in OUT - \text{Step output} \\
    ic &\in IC - \text{Ingredient collection} \\
\end{align}
$$

### Formation rules
$$
\begin{align}

r ::=& \; r_1, r_2 \\
\mid & \; \text{main recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} } \\
\mid & \; \text{recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} }   \\ 

id ::= & \; iti \; ii \; ad \\
\mid & \; id_1 \text{ or } id_2 \\
\mid & \; \text{recipe} \; ii \; \\
\mid & \; iti_p \; iti_c \\
\mid & \; id_1 \text{ , } id_2 \\

td ::= & \; ti_p \; ti_r \text{ [ } tad \text{ ] } \\
\mid & \; ti_p \; ti_c \\
\mid & \; td_p \text{ , } td_c \\

tad ::= & \; tai \text{ : } iti_i \text{ => } iti_o \\
\mid & \text{ contain : } iti \\
\mid & \; tai \text{ : content in } ti \text{ => } iti \\
\mid & \; tad_1 \text{ , } tad_2 \\

sd ::= & \; ti \; \text{ do } tai \; ds \; in \\
\mid & \; ti \; \text{ do } tai \; ds \; in \text{ => } out \\
\mid & \; sd_1 \text{ , } sd_2 \\
\end{align}
$$

## Additional sets and auxiliary functions
- $x'=x[y \mapsto z]$ denotes that $y$ maps to $z$ in $x'$
- $x'=x[y \mapsto \epsilon]$ denotes that $y$ is undefined in $x'$
- $x(y)\downarrow$ denotes that $x(y)$ is defined.
- $x(y)\uparrow$ denotes that $x(y)$ is undefined.

### Recipe environment
$$
\mathbf{EnvR} = RI \rightharpoonup \{\text{reserved}\} \cup RI \cup EnvT \times EnvI \times EnvIT \times EnvP 
$$

### Ingredient environment
$$
\mathbf{EnvI} = II \cup (\{ \text{content in} \} \circ TI) \rightharpoonup ITI 
$$

### Action environment
$$
\mathbf{EnvA} = TAI \cup \{\text{contain, remove}\} \rightharpoonup ITI \times ITI \cup ITI 
$$

### Ingredient type environment
$$
\mathbf{EnvIT} = ITI \rightharpoonup ITI
$$

$$
\begin{align}
\forall env_{IT} \in EnvIT. \: & env_{IT}(\text{Ingredient}) = \text{Ingredient} \\
 & env_{IT}(\text{vegetable}) = \text{ingredient} \\
 & env_{IT}(\text{fruit}) = \text{ingredient} \\
 & env_{IT}(\text{meat}) = \text{ingredient} \\
 & env_{IT}(\text{liquid}) = \text{ingredient} \\
 & env_{IT}(\text{spice}) = \text{ingredient} \\
 & env_{IT}(\text{nut}) = \text{ingredient} \\
 & env_{IT}(\text{dry}) = \text{ingredient} \\
\end{align}
$$

### Tool environment
$$
\mathbf{EnvT} = TI \rightharpoonup TI \times EnvA
$$

### Procedure environment
$$
\mathbf{EnvP} = PI \rightharpoonup PI \times TAI \times (II \times II \times \dots \times II)
$$

$$
\forall env_T \in EnvT. env_T(\text{tool}) = (\text{tool}, \emptyset) \\
$$

## Transition system

### idk transition system


$$
\begin{gather}
\frac{
    \langle r, env_R \rangle \rightarrow_r env_R'
}{
    env_R' \vdash r \rightarrow_c \text{bon apple tea} 
} \\
\text{if } \forall ri . (env_R'(ri) = (env_T, env_I, env_{IT}, env_P) \land env_I = \emptyset \land env_p = \emptyset)  \lor env_R'(ri) \downarrow
\end{gather}
$$

### Recipe declaration transition system 

$$
\begin{gather}
\frac{
    \langle id, env_I, env_{IT}, env_R[ri \mapsto reserved] \rangle \rightarrow_{id} \langle env_I', env_{IT}',env_R'\rangle 
    \;\;\;\;
    env_{T}' \vdash \langle td, env_T\rangle \rightarrow_{td} env_T'
    \;\;\;\;
    env_{IT}', env_T' \vdash \langle sd, env_I', env_P \rangle \rightarrow_{sd} \langle env_I'', env_P' \rangle \;

}{
    \langle \text{main recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} }, env_R \rangle \rightarrow_{r} 
    env_R'[ri \mapsto (env_T', env_I'', env_{IT}', env_P') ]
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    \langle id, env_I, env_{IT}, env_R \rangle \rightarrow_{id} \langle env_I', env_{IT}',env_R'\rangle 
    \;\;\;\;
    env_{T}' \vdash \langle td, env_T\rangle \rightarrow_{td} env_T'
    \;\;\;\;
    env_{IT}', env_T' \vdash \langle sd, env_I', env_P \rangle \rightarrow_{sd} \langle env_I'', env_P' \rangle \;
}{
    \langle \text{recipe } ri \text{ \{ ingredients \{ }  \; id \text{ \} } \text{ , tools \{ } td \text{ \} , steps \{ } sd \text{ \} \} }, env_R \rangle \rightarrow_{r} 
    env_R'[ri \mapsto (env_T', env_I'', env_{IT}', env_P') ]
} \\
\text{if } env_R(ri) = ri_p \\
\text{and } env_R(ri_p) = (env_T, env_I''', env_{IT}, env_p''') 
\end{gather} 
$$

$$
\begin{gather}
\frac{
    \langle r_1, env_R \rangle \rightarrow_{r} env_R''
    \;\;\;\;
    \langle r_2, env_R'' \rangle \rightarrow_{r} env_R'
}{
    \langle r_1, r_2, env_R \rangle \rightarrow_{r} env_R' 
} \\
\end{gather} 
$$

### Ingredient declaration transition system

$$
\begin{gather}
\frac{}{
    \langle iti \; ii \; ad, env_I, env_{IT}\rangle \rightarrow_{id} \langle env_I[ii \mapsto iti_c], env_{IT}\rangle
} \\
\text{if} \; env_{IT}(iti)\downarrow \\
\text{and} \; env_I(ii)\uparrow
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    \langle iti_p \; iti_c, env_I, env_{IT}, env_R \rangle \rightarrow_{id} \langle env_I, env_{IT}[iti_c \mapsto iti_p], env_R \rangle
} \\
\text{if} \; env_{IT}(iti_p)\downarrow \\
\text{and} \; env_{IT}(iti_c)\uparrow \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    \langle id_1, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I'',env_{IT}'' \rangle \;
    \langle id_2, env_I'', env_{IT}'' \rangle \rightarrow_{id} \langle env_I',env_{IT}' \rangle \;
}{
    \langle id_1\text{ , } id_2, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I', env_{IT}'\rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    \langle id_1, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I',env_{IT}' \rangle \;
}{
    \langle id_1\text{ or } id_2, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I', env_{IT}'\rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    \langle id_2, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I',env_{IT}' \rangle \;
}{
    \langle id_1\text{ or } id_2, env_I, env_{IT} \rangle \rightarrow_{id} \langle env_I', env_{IT}'\rangle
} \\
\end{gather}
$$

### Tool action declaration transition system

$$
\begin{gather}
\frac{
}{
    env_{IT}, ti \vdash \langle tai \text{ : } iti_i  \text{ => } iti_o, env_T \rangle \rightarrow_{tad} 
    env_T[ti \mapsto (ti_p, env_A[tai \mapsto (iti_i, iti_o)])] 
} \\
\text{where } env_T(ti) = (ti_p, env_A) \\
\text{and } env_A(tai) \uparrow \\
\text{and } env_{IT}(iti_i) \downarrow \\
\text{and } env_{IT}(iti_o) \downarrow \\
\end{gather}
$$

$$
\begin{gather}
\frac{
}{
    env_{IT}, ti \vdash \langle \text{contain : } iti, env_T \rangle \rightarrow_{tad} 
    env_T[ti \mapsto (ti_p, env_A[contain \mapsto iti])] 
} \\
\text{where } env_T(ti) = (ti_p, env_A) \\
\text{and } env_A(\text{contain}) \uparrow \\
\text{and } env_{IT}(iti) \downarrow \\
\end{gather}
$$

$$
\begin{gather}
\frac{
}{
    env_{IT}, ti_1 \vdash \langle tai \text{ content in } ti_2 \text{ => } iti, env_T \rangle \rightarrow_{tad} 
    env_T[ti_1 \mapsto (ti_{p_1}, env_{A_1}[tai \mapsto (\text{content in } ti_2, iti)])] 
} \\
\text{where } env_T(ti_1) = (ti_{p_1}, env_{A_1}) \\
\text{and } env_T(ti_2) = (ti_{p_2}, env_{A_2}) \\
\text{and } env_{A_1}(tai) \uparrow \\
\text{and } env_{IT}(iti) \downarrow \\
\text{and } env_{A_2}(contain) = iti_c \\
\text{and } iti_c \in env_{IT}*(iti)
\end{gather}
$$

$$
\begin{gather}
\frac{ 
    env_{IT}, ti_1 \vdash \langle tad_1, env_T \rangle \rightarrow_{tad} env_T'' \;\;\;
    env_{IT}, ti_1 \vdash \langle tad_2, env_T'' \rangle \rightarrow_{tad} env_T' 
}{
    env_{IT}, ti_1 \vdash \langle tad_1, tad_2 , env_T \rangle \rightarrow_{tad}
    env_T' 
} \\
\end{gather}
$$

## Tool declaration transition system

$$
\begin{gather}
\frac{}{
    env_{IT} \vdash \langle ti_p \; ti_c, env_T \rangle \rightarrow_{td} env_T[ti_c \mapsto (ti_p, env_A)]
} \\
\text{Where } env_T(ti_p) = (ti_{gp}, env_A)
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT} \vdash \langle td_1, env_T \rangle \rightarrow_{td} env_T'' \;\;\;\;
    env_{IT} \vdash \langle td_1, td_2, env_T'' \rangle \rightarrow_{td} env_T'
}{
    env_{IT} \vdash \langle td_1, td_2, env_T \rangle \rightarrow_{td} env_T''
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT} \vdash \langle ti_p \; ti_c, env_T \rangle \rightarrow_{td} env_T'' \;\;\;\; 
    env_{IT} \vdash \langle ti_p \; ti_c, env_T \rangle \rightarrow_{td} env_T''
}{
    env_{IT} \vdash \langle td_1, td_2, env_T \rangle \rightarrow_{td} env_T
} \\
\end{gather}
$$


## Step declaration transition system

$$
\begin{gather}
\frac{}{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} }, env_I, env_P \rangle \rightarrow
    \langle env_I[ii_1 \mapsto iti_o, ii_2 \mapsto iti_o, \dots, ii_n \mapsto iti_o], env_P \rangle
} \\
\text{if } iti_i \in env_{IT}^*(iti_1) \\
\text{and } iti_i \in env_{IT}^*(iti_2) \\
\vdots \\
\text{and } iti_i \in env_{IT}^*(iti_n) \\
\text{and } tai \not= (\text{remove} \cup \text{contain})\\
\text{where } env_T(ti) = (ti_p,env_A) \\
\text{and } env_A(tai) = (iti_i, iti_o) \\
\text{and } env_I(ii_1) = iti_1 \\
\text{and } env_I(ii_2) = iti_2 \\
\vdots \\
\text{and } env_I(ii_n) = iti_n \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} }, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_{i_1}, ii_{i_2}, \dots, ii_{i_n} \text{ \} } \text{ => } \text{ \{ } ii_{o_1}, ii_{o_2}, \dots, ii_{o_n} \text{ \} }, env_I, env_P \rangle \rightarrow
    \langle env_I[ii_{o_1} \mapsto iti_o, ii_{o_1} \mapsto iti_o, \dots, ii_{o_n} \mapsto iti_o, ii_{i_1} \mapsto \epsilon, ii_{i_1} \mapsto \epsilon, \dots, ii_{i_n} \mapsto \epsilon ], env_P \rangle
} \\
\text{and } env_I(ii_{o_1})\uparrow \\
\text{and } env_I(ii_{o_2})\uparrow \\
\vdots \\
\text{and } env_I(ii_{o_n})\uparrow \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \text{ \{ } ii \text{ \} }, env_I, env_P \rangle \rightarrow_{id}
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; ii, env_I, env_P \rangle \rightarrow_{id} 
    \langle env_I', env_P \rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{    
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \text{ \{ } ii_i \text{ \} => \{ } ii_o \text{ \}}, env_I, env_P \rangle \rightarrow 
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; ii_i \text{ => } ii_o, env_I, env_P \rangle \rightarrow 
    \langle env_I', env_P \rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_{T} \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} => \{ } ii \text{ \}}, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_{T} \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} => } ii, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \text{ \{ }ii \text{ \} => } \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} }, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; ii \text{ => } \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} }, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{IT}, env_T \vdash \langle ti_1 \text{ do } tai \text{ content in } ti_2, env_I, env_P \rangle \rightarrow
    \langle env_I[\text{content in } ti_2 \mapsto iti_o], env_P \rangle
} \\
\text{if } env_I(\text{content in } ti_2) \downarrow \\ 
\text{and } ti_i \in env_T^*(ti_2) \\   
\text{and } tai \not= (\text{remove} \cup \text{contain})\\
\text{where } env_T(ti_1) = (ti_p,env_A) \\
\text{and } env_A(tai) = (ti_i, iti_o) \\
\end{gather}
$$

$$
% \begin{gather}
% \frac{}{
%     env_{ITI}, env_T \vdash \langle ti \text{ do contain } ii, env_I, env_P \rangle \rightarrow
%     \langle env_I[\text{content in } ti \mapsto iti, ii \mapsto \epsilon], env_P \rangle
% } \\
% \text{if } iti_o \in env_{ITI}^*(iti) \\
% \text{and } env_I(\text{content in } ti)\uparrow \\
% \text{where } env_I(ii) = iti \\
% \text{and } env_T(ti) = (ti_p, env_A) \\
% \text{and } env_A(contain) = iti_o \\
% \end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle \text{START } pi \; ti \text{ do } tai \text{ \{ } ii \text{ \}}, env_I, env_P \rangle \rightarrow
    \langle env_I, env_P' \rangle
}{
    env_{IT}, env_T \vdash \langle \text{START } pi \; ti \text{ do } tai \; ii, env_I, env_P \rangle \rightarrow
    \langle env_I, env_P' \rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} }, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle \text{STOP } pi, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P[pi \mapsto \epsilon] \rangle
} \\
\text{if } env_p(pi) = (ti, tai, (ii_1, ii_2, \dots ii_n)) \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_1, ii_2, \dots, ii_n \text{ \} }, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle \text{STOP } pi, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P[pi \mapsto \epsilon] \rangle
} \\
\text{if } env_p(pi) = (ti, tai, (ii_1, ii_2, \dots ii_n)) \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_{i_1}, ii_{i_2}, \dots, ii_{i_n} \text{ \} } \text{ => } \text{ \{ } ii_{o_1}, ii_{o_2}, \dots, ii_{o_n} \text{ \} }, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle \text{STOP } pi \text{ => } \text{ \{ } ii_{o_1}, ii_{o_2}, \dots, ii_{o_n} \text{ \} }, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P[pi \mapsto \epsilon] \rangle
} \\
\text{if } env_p(pi) = (ti, tai, (ii_{i_1}, ii_{i_2}, \dots ii_{i_n})) \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle ti \text{ do } tai \; \text{ \{ } ii_{i_1}, ii_{i_2}, \dots, ii_{i_n} \text{ \} } \text{ => } ii, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle \text{STOP } pi \text{ => } ii, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P[pi \mapsto \epsilon] \rangle
} \\
\text{if } env_p(pi) = (ti, tai, (ii_{i_1}, ii_{i_2}, \dots ii_{i_n})) \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{IT}, env_T \vdash \langle ti \text{ do contain \{ } ii_1, ii_2, \dots, ii_n \text{ \}}, env_I, env_P \rangle \rightarrow
    \langle env_I[\text{content in } ti \mapsto iti_o, ii_1 \mapsto \epsilon, ii_2 \mapsto \epsilon, \dots, ii_n \mapsto \epsilon], env_P \rangle
} \\
\text{if } iti_o \in env_{IT}^*(iti_1) \\
\text{and } iti_o \in env_{IT}^*(iti_2) \\
\vdots \\
\text{and } iti_o \in env_{IT}^*(iti_n) \\
\text{where } env_I(ii_1) = iti_1 \\
\text{and } env_I(ii_2) = iti_2 \\
\vdots \\
\text{and } env_I(ii_n) = iti_n \\
\text{and } env_T(ti) = (ti_p, env_A) \\
\text{and } env_A(contain) = iti_o \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle ti \text{ do contain \{ } ii \text{ \}}, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle ti \text{ do contain } ii , env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{}{
    env_{IT}, env_T \vdash \langle ti \text{ do remove \{ } ii_1, ii_2, \dots, ii_n \text{ \}}, env_I, env_P \rangle \rightarrow
    \langle env_I[\text{content in } ti \mapsto \epsilon, ii_1 \mapsto iti_o, ii_2 \mapsto iti_o, \dots, ii_n \mapsto iti_o], env_P \rangle
} \\
\text{if } env_{IT}(iti_1)\uparrow \\
\text{and } env_{IT}(iti_2)\uparrow \\
\vdots \\
\text{and } env_{IT}(iti_n)\uparrow \\
\text{and } env_T(ti) = (ti_p, env_A) \\
\text{and } env_A(contain) = iti_o \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle ti \text{ do remove \{ } ii \text{ \}}, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle ti \text{ do remove } ii , env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle sd_1, env_I, env_P \rangle \rightarrow \langle env_I'', env_P'' \rangle \;
    env_{IT}, env_T \vdash \langle sd_2, env_I'', env_P'' \rangle \rightarrow \langle env_I', env_P' \rangle
}{
    env_{IT}, env_T \vdash \langle sd_1, sd_2, env_I, env_P \rangle \rightarrow \langle env_I', env_P' \rangle \;
} \\
\end{gather}
$$

$$
\begin{gather}
\frac{
}{
    env_{IT}, env_T \vdash \langle \text{server } \{ii_1, ii_2, \dots, ii_n\}, env_I, env_P \rangle \rightarrow
    \langle env_I[ii_1 \mapsto \epsilon, ii_2 \mapsto \epsilon, \dots, ii_n \mapsto \epsilon], env_P \rangle
} \\
\text{and } env_I(ii_1) = iti_1 \\
\text{and } env_I(ii_2) = iti_2 \\
\vdots \\
\text{and } env_I(ii_n) = iti_n \\
\end{gather}
$$

$$
\begin{gather}
\frac{
    env_{IT}, env_T \vdash \langle \text{server } \{ii\}, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
}{
    env_{IT}, env_T \vdash \langle \text{server } ii, env_I, env_P \rangle \rightarrow
    \langle env_I', env_P \rangle
} \\
\end{gather}
$$
