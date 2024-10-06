package strings.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveCommonCharactersAndConcatenate {

  public static void main(String[] args) {
//    String s1 = "aacdb";
//    String s2 = "gafd";

//    String s1 = "abcs";
//    String s2 = "cxzca";

//    Expected: -1
//    String s1 = "myqfsvzzrrzokoxdgkeozmtemcnfofkpwtbnveghnitbnsvrsvedldrvfoblzumxzxqandpdeqzhhcdzdtvwoulqcjycgtpamgcfpjvthwiodocdqbucaymfyhzinxjyifrklloqmagglnvshpgfghnbzybnqxhrwlmatmibfbtakhodkgnedayikjgryigdhcbdtdnafbczqromejevrnomjrfmuauwgozczhntofhpncavvfvexgbpykbzcowuyobluswgbjmxcemeixdrggrtkysiaxzbxenehbqhcidnbahffobwbuezbcjnscdvlvqwcepvzvtvpsyxobfoosrxipysewmxqlojlfpwnllroxteknivyyiellsdzsezpqimtbdsihulajigtrqkjfptqbooslfuhhbumrsxicwfidizsdqkdfbeqwsvfqnbundpytvjqtphceaxhgnbptvjflfyogwkuillcfqgtcmboptesvldpglkhzpcjrivxeigcircascctdmeurburhmfvwxvxenxsyqwjmfraypanafbrzucwddnhoaojixezeetjgttilibkjqdraqtwlgjlsiwfeydevdjimvslssjjeuvttcdpwtnygutvbgsogxnnqczqudmgcijugnhgypilddjddqiccdnkybukquwcficrwjbhircmuhztlrtioodtwjxnuqhrenzzcsdtzgdvyjicpybacuhfvomhvxwxgyvnttjqsxzgmishmhyvfhrukqvseqnzxrvuunzmyqgjnycaeqcvnanquwvxekrbkvfjuptuorvssfqfwqomrmtejppbqfqezdkpuzxattupjqirdematqfwqkjejrbkljmqdhmmmlirvegqywfccqehehwiqxcxuzwsqrglctorfsykqryvfeykyzwrickonuytvqourkmegfmirontpmcsfsblmlbvtfjevqvrgjomnfaykvuufmrhdhnzecqctvdvrzxmkisrxcxtcvvizmjmjzwstznocjnggugnoaqejtvxwnuugeowlwcokixxorbdrzhsluhyoftakxketkptorulihsfshiizvzwgseaykcbsszaxyafsumkuwmfckeqrfmcmnhuwbzgmpevpjuzkqbzbxrpdfcahjjulpbkoljbkgjaimlbdgkaoslyloefsgqoalaggqcvltlzbmyjxkxoznhenkobhlvyqsyqvhtprniqdvzkfpkrlauzuoochhgbqyxtqdrhlxxxxdupvwqomjemwiyrvqrixwswbecbpaiwvhbbujofsiqhwhrgagalmzpenejjjokfiegqyxqyquyhwiarbajqcrhoceofhcpsrzsgspdgjegavthnmrptpwcmthzwpxanjidtthrjxagmfebgomyfaszqagipuxzgdecnwdmgavkuboexpvxujpcgewvetvgngkixwambfuqeieumssdsdntxqdvjldtmnqpvabngkttmlttxhpyomyacbhceysmbrnpdfnbumznnvwdzvaydpalfqtpmvjrvqpbhvxyjcgzbsntwnnkpbbdyfilmjoynnqeqdlolpxaafcnertdeywmuhmcifvuisxkoazagulmriqooefdfdkvbmuikkbjufcondeqbcefwiufycetomwyloznqmlvhzdykvflrchaqjyqkewfzcwckkrtgkogoxmqgfscwidgtcnxjganwfqplhzrbepknbkgdsyvqtgddkocmlsveqnjfpmeezuhkasmpyegzrjgztlnjadlnukrmwaahxjzyiywnisoqyyjlchgegktjoqpctniyvzkyststpnpwxwaojfnbehhklespwoksynxseymhaomhdoxkzxriejeunymawsibhxqmldkdkvbzueovygmprsukhisnnwardeocahpmcqbcmzpalqqovhubprsojrffixestgnxjswnyjutpgdwnvzqvqqmvrzxvtypntguqsmaejjcjnzsbyndmxaqwwrozikcyzmvqjppxatqyzkrsvwydxqycflanixtbyxiphenhjshbladxbdoaojwdjexdcmkqhocqrljyuynutkdacxftbvvugwmdrhksryacczpkbvlemihwjkzlbdfvzdrhsfveslcmkqhpybrjtznhhlfbipyjtngxpqffuwsrirsglomzmeooouxppigraoyyactuydcoocwuuquvohwzaxwajcwqtlseunxenakuhdfjqwhswktxcmakrrxhjywowdbewjbtydxkgkcwiovjhpzhherhewoitcumkomkptffzlnbfaneawudbvulqxoaehcxvbphklxkjvjukesnmrbvmbsxuwodnaqaffqfwmbznrypnxsytephhmwmbrdkymsazasmnufgzzwrnlnatcggsthlwtolgsmygtzytzdcxqorairlhvikoistiozywazbsdrpmpwhfuqgjkzzgruoavmlldumqujwygdonenbiggvvdmhcigdgkggvqrljgllxmnxlelawefdkzrqmamkffrhvsvmwsphfngsklqbzrhbtiplnbxgajccqrduzbdqxrcrijgjatsugghtfhfspgkesctkouqmwpzndbmfcmdigcucahqtfxfvykrrelykwvulhdaefeswkevozdbfaknktafdrvlxdqtgniwkgdmxmujwqjylbsmhjfhlxawrmeofqzpleaxunuiwxrqtvlpxztixucvwfiwiphlqfgnkoewzcnvzinntuxlsxtetimbntvbrbxfersswenjcdfsbihiqukswpfnzifzxzivdrygctlddgzyavlxecpfwtbdkygrdjtsvprkswvnmqanywzrpsrolcfhjzjmwjggjfzjkcjxfyckgsrewhedtfxgjacurvpzsayzhggepvksagtsqbbavjgqjmeleqmuttgfnusxcpgjjkpyjacsyuapsyziiwhtxgxnsyxpjikzunrmcennyvzwmmnudozyvhxzrirfrauywurtbttcdrvnacuzulogsleonqcedrecyxapmnnrosgdofdbbevrzdyqvyyrujtyqvgqgtpkpfoyxmkadnfppxlhmshfvvlfrevnkwaqrnjklswgzesdcygaowmxbumrwjvuadclrgighfcmfriznlbnfidlezrwihixkiljcvpuivebeysinrtucbqdjmgjzsaxnmbqxnkqwyapgpbupsbsvylntbqqlhpldxuhckfpjyyoyxbtmgscbagapnybaskexewdsuwmsruuuvvqtmrkflvtwzepscpvjwvsdwbivhwwhshbhjaibzkspojoicwptntaonybpmgnuudgeuactfbvvjfkamjvwemkfivflmxpolhaxroqgeiyrgjgpzqctpdmpndaactqkqjmtjqyumwurrjtzslrczqsbisuvvsqscvizljysgtvinmhobqifbdnqvhohmsqzmrmyfzcjjyhohhqfvxnzzwjjcbqbpxotvxebzgmvhobddpsvvlwwynucxpeqsdyhdmebczusjkqqivmkdkylbzryeiyusenpwqvdxoxcslmqqfkmypihwdnefozcmmtarpeetispgffdckoiihdtwfcjiqztwmvrjplegjjogzucvmzoosqwxsagwzcuvucaqcmiwawqhdbjdczlbugtgcpuernwyernzgivhdehxemzxyzkbkenadzehdzcteintvdgvkpgcolyurzwiznuffhnvxoppuhgugbyqzxtdifrzevaxlkjqkosotcxbgatevjgucoajnuxmzirwvvrqaujfdwntcfbuhnfhovrrdofxzqudxshrtnbvuqdifezryhlzmtbulhupiqbgrysdwpxdcmttjlautgpxaceytbadfctofzryxjyfqakihdbmobcgfunfivkxqsrotnlqlgzdedfufjrbsobttlqgiacgsbyejxepbuflpssjkdpxxvroicqcofodwltknrndepfcvvzoybnjkyvvoyebzkfybgzooqcmxbghkedgwgmopvubbxxqghqkophvwqlkspknfjkpigjsrbxburecejcwbmrhsplxanixzxvgjjzcotfkfacplggslveenwvxcbmxqzvhvyhpuroextuuuqujglgxbhhesactdaxdrfobvnzzrymvkoknhwkbkafbdnznqfwvpifxvelbpfbddirjmzwkpsmzhgcvbhjvnaqghodwnlddsdbowqnefughknvcwbzydroucbcsbwupvvdyyncgkvebsddjxotfpmguwkhnzdzaykwyaxpgpwkjjquqwflcflfxcxxlxsznqxiavmloeewigahzfquujwctweqevteoxylrjhkopktrjjwoybqksyoiaytxafuriqmazgttclawfmkimxpcexizyatraeesfnvgnpsutwbkvywdrawijbvtsczbbtqtbfddyjodcfwanvqzoqwjvdopyccrpwnusbxplaigeeiwjftlaspqsjlxlgdfmdqpqpnefeuzblnvfirwpmekghjczixqmjkkzrbirsqrkfsqllpudzrenizvprphzsctvqxzredoqjenwilinjmehxieeaafuupipyvigqvafcgrslczkmyyrqvgofoalqovfbmaubrapzphkjhvszxlhtpbxmcmrrjasgawruyhetsnotresqzwfbflketzdgtskzummjtbqpapvdtdmxqdrsfdstevrfcqgxkuyodmaivmjpipitfxbqozjtimxikhskcdglzvfborneptgealdnohitgaivujuidkhiuqzcadxoewuqwzxctjzfrvtypufeogpunbbbusoxasgivgeikooxdraadhvklpaiusddrlklehlguuswevlkjjwfmljsmwbcqwpekncvjmpbgaiznnujkibbbqhhqyskljbugykmuylbefmytgxqtrxwknysjxnftyosjzqrodoixbninuoznouzavswisslzseucqmfqewrfxdkxuzcrtaiwenimtbemuqfjowxqofmbmjjyrphuvntxbrfgsmfuyatsruoxzdyjcljvtmbfxfhwlkarardpbpksuarlsmjqfiktnshhwqjucjygjdrqojdkmhhmmjdwnodhyrbomrpobfcwlunboomlvnutvmbotkukwzzjscvavimdsmfzacfiwksfnzbxrgfvqqabjbwrsrcgprtzsntnqeycfldmzslylwslbyegyuusnvvqwiteelxsqiagocowhavygfzaozruxkphyzmzobkmdexhlgblteklruqcbawbnchppxjlowpmlzvocvqzoxlfttpxonrgfpvbiwhtxauvgosyzmxzormgwjaiynskcpldkhxckidbqfkwphtovhidygwwxwvizbgizcunlukmsadzllsaalubvynejntdsfvxbsfaffxrxypuagbdeyejpqdynjgdmjxdfzqplggjxfmcvgqugauavwxdwoonkzitcwldzfxghlsuahxnqumloeegogyashxchxakqcmmsettdndfskkbiwksyxnfhjsjkbozpmogkgdltkswghfbptbutplbittsliydqwwcmoebbluoevyirndjhbqwjuxqchrxswxztbywigfrskvmxhpcvgcgjocdxzagghpojjnvsggzwqsuhfrjfghcmtsoafarmpyoxbehfekbkfajxadfuqjcbzfpboopqojccpgjtwdukkdoezkdtskfhoksaetahguiyfnmesbwcipgtomgcqqoecizpgkribttvzvgewewubjocbofmatopljbpuvbahjzmbtcbypokyxvpxpxmylkgvbuzqyrorjjqltkjlfuzxphboqjcrwrkkymgcquyjdphpfwevizuysrgltiivkjkrjwagjrssosiuldtwakfppaoavfoxyjpaesdanjpptxasisdzlzxusdvyvobyjdffvtikbqumpzqpbthymjfznnwxfwxyecagrocyfvzxaxcjksplfyvlktmfbcsfbucnbjegmwnyrpagjabsieemzkluanrbiizqfsavazrlmsmcyxuucuohtnrpcgqagbfxzcuvtbdbpjgjgktpklmppdicbqgbrptfslaaadperhegmxbrcgxsxkfwcwsfrrkuoykojoulmjdstakhwirirjgkemgehpvmrsgdolswwcghydgvspduejpcjrnpdielrisdqibasdkosojfovmxqnncvukicyndhjgwqppvelbhgoddevsbtyxkmugziczqieubnsjvobvipwsbmdcjifzuqupkfzraauxwiulxndxbmvnisgythfsnafvlkskzbqkzyzqlrswzfzbpqvxpoygoxyfofygvvwymshzytlpqitdgqnytojinnnmgbxlpnzrrnyrnpdinqcxorttxuhvrqnfleyvldfhqqzsedvrnpfwbazjvgtbeayujmjvbhyhnxkigseyylnmrnysvwszwoffwauznemaaaczmuphrniaggozhwpyxpkyjieddzntazntlwfmrrdpywujusdejgiftgovpkgczjggsiytjravftylybxesqwojmcilvujkbeffmnsyegfwrjbhgsdrcqgyjeestkyeoapdfabefbrxvmdjpyverxmewtfumsrptdvqtleoaucbhdriwcxgkrxcvibjsrsntyvwclpststjjldiejtogbroszhbnkjxbgeprvmcubwjyafdxamyfxfywpwomgyumjqfclkgmuclyvmehstarqhkrtisocnclaqcfuwyvnitaghtxuiztfcezskdnmvwispylmcihdoxayfpxriyvxjshnhrvzxojinbqmqsjqtsucgijxttnbggrgreunembjhjzwegtxwihvbhwnwdybqdfpvlrfqkywfnwzlxcvxfpkyqboywaapdcflezldoamyhrsnhajelothsufxyikcppeofhakqgzbzpfwzhmkkjvmnvpebamoqnndmclomgsoryjxasxocbamswrgneepkvvolhhsldhufkudmhttxvdjhxqggtlajyxwqhnifbnaqcnyrhogbsqdvtfswlicqtkcbhvetquyrxixiqbnwvszwhtcgihrmbfyzaowunahcfgkgczoxvqmqxurehtctznmogekcyfrecwknknmivrephzgnigeqxgnanxktroxxazyyomaicocxijbkljxftrdnswaebvyfhgqtmvysijbbybrxvudylfidzkkwvwwioqhkzvjopntynehcrcznsvyiscujgjcuqoetxosalxcempdhbuosjccmeltccltdlckmwzltlsdolxewrxrtslghbtmtdiddhjztfrbsahcoaczulamsrnfllegclqurvyjflrzzyxriydmhhrumcvuxdiflyxujjapomhtddzeosvhhfluzkewfuabmfgxjjymbyvdcpqasqntqdiqajedrcqrlspzpgbstxxsckrtsswlwwcxyfipdfmarnxmvuuekpfzhjigrchkttcrrntjljiiyqoexfxfkwgdndekbgnxlfprfciakepanqvpncxjtwubysokpflqiuiqvcibtjdpxthhwwatlpkpzydmcigxujiwqtcsinveejzatkyodlzriyaemngdwknfqtpyuerxuegscvowrewwaeawxgarmpxaeojgvcqqdgfoigrhjbstugqqeqbnixhmeybglqtypkzlfujgztqgwteoytquyqlyqbiwoulqfdwgnocslstigonvddavgwopalzbmcppewhngxtudchovbkeirisklndqkbubjazohbwufilxejocbwuhxfgygpuwkvavtrdwqjocysdbkbqzjabonpezanzqwczrdweiuueuahetmqvpibfnmfwhnzphtybzpykuxzitkfdncolsaebqtjenzclzdwqwfajkhxryxvhebxscoimperxnkqjzcsovevcgzsuljummylcdywhuncmwlhncvfzcmqcfxtrwsyvnnvwnkmbdelkpzmfekxxdvyjvuyzfiflzupdodxgbtmeggavzlxqnscwxwcbsaikgbbnozaeqtpycqmtxvgynttgcjhfisjhrdrudgyiybvojxbkkmexloymiqamlibvtgsswiarrtaffpvndccduyvwxfuxbzpogsvyfqdjvdfuvpqnssaeutfurozmdeerxnjyjdsvsublhsmuvinbngzpwacpzxlqartufvvmgibdtkofatbfvxkyjqpjmuksrzvptmfkslgbvpqkxxxkmkdygjndfqassmzldxkdgwplzgksykqvmcgnypcsyjtwfhynsuscbhhoefasbhrvxxcwxebkwhcdyiooelquhosragokieryugnxwmlmbmhhyvouubhalmtscsjdfwerzbkxtbufsjvbvxhyoezzvwgpshznlnxuvortqwvnbptggsoxbuelqszjrclrkdmwpcxjujodgoapymwwvqjisytxnlkeujfatnvklqenvilehwlpkyudeuvyagiuflrmnbeccrvowluvrkmsygidgsvtiqlohnhlshbekrkineosmebsyhauhjriwlnfqzuujtadbgmccjqniflekevtjmwjyhmbcejbivgtyuczuszwoeozdvgvepcfhvrryjomgwrhmzpfbeyeihrrewassoopohmiocninwjmknuhjcoahsnwdskxhctnrvgemvkelghorzuewyyvxxwwjfytorikqkdhcfizyiqstkvrgwfftlsvdhxuylwzfdjweixqiqldvzuspoqqnsklsqztvjuyaolyaivdvzbjpaanfidtuecsfrxdyxdcofsuakasxvqrxlmtcizzmylmginsvltwwdmbuiocvlmnjljhxwxbsmkdyvhawylqmmlrycywhntabwqbmoqbcrcibyjwnjdptcukthqacvanxaickezbbnokrfuduoddbzhfjenhbgnuhymhgodpjubaoneydhcdkmvviwoqkkuarmyqkqjpmpseanyflyticnjeubsthjjftvvmcwprkieobalvadgybyevnbkjpgnqydzmrzexvethzwnhdbrcxcrzpernpjgyuiegowmtbdeakjuntxrincpmkwsxhirlbbffdwabcpmdfokugbuvbotqjgaqmyoenwpsblgifhwlohjgyfbuqirasaplsaakgxktqjbjwplhacsiogdbdnyyvuyavyanqnlscpktrboesieknudpohmowunnxabozbektepykmucblorpvwxjobyvdkbkcooqmqutprfpcfxcosofefxfqqpmoqtasmndotjyasaydushbnvxtjwjychtlmkdeqgutowfbyjfyjapgqbdecjxjxxaiekuimrllcrogucckegzyihbexasnpwvtwrfzftqoxymhweariodbsujgiciuvtnltjrscrdrjuaowtdvwngxoqnkdfrixgmobodgkbmgxamzunmocnoxztlglkfqwtjgrettewzbhcyjztisifpofqnixgclvixeilbblausifgxpswnlanegoskttcvxxhczlwnsowehuuznanvnodthzynpyhqjimlvexourphbjjxzkhpdivddobaydtukhigxeibydxvjmfewadmlgamdczvmjvqjmuuexmecvsmwilkxtwbhxddmhecsjdkqjwnebbrxwyyjdphtsomnekvaqcovlroobdpovjacmmszrcepdyuhzfkpmfrmshlpzhcrwsbkebzqqibenglsrcmgjqpgfhdjgdyysilknzunvrcttwpzlbbrihhwid";
//    String s2 = "zyadcklhozxnrwwcycqvahognypfbwbbehobkdhadehurslniqhpkwvgzfetjoupwssnjhjhlrdkkgboitvzdtrbeljwnmme";

    // Expected: qqjjotooozmimtlmoolz
    String s1 = "rqunudsgdgbcuyqywbvghxsuakuefup";
    String s2 = "wkjjeocntkowhoofkrbszakvdvrhamyywhidymstwgpdxglhxmcyoourlnz";

//    String s1 = "aabcdpttbc";
//    String s2 = "tbcpabd";

    System.out.println(concatenatedString(s1, s2));
    System.out.println();
    System.out.println(concatenatedString1(s1, s2));
    System.out.println();
    System.out.println(concatenatedString2(s1, s2));
    System.out.println();
    System.out.println(concatenatedString3(s1, s2));
    System.out.println();
    System.out.println(concatenatedString4(s1, s2));
  }

  // Function to remove common characters and concatenate two strings.
  // NOTE: Order of elements not maintained
  public static String concatenatedString(String s1, String s2) {
    Map<Character, Integer> s1Lookup = new LinkedHashMap<>();
    Map<Character, Integer> s2Lookup = new LinkedHashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      s1Lookup.put(s1.charAt(i), s1Lookup.getOrDefault(s1.charAt(i), 0) + 1);
    }

    for (int i = 0; i < s2.length(); i++) {
      if (s1Lookup.containsKey(s2.charAt(i))) {
        s1Lookup.put(s2.charAt(i), -1);
      } else {
        s2Lookup.put(s2.charAt(i), s2Lookup.getOrDefault(s2.charAt(i), 0) + 1);
      }
    }

    s1Lookup.putAll(s2Lookup);
    StringBuilder builder = new StringBuilder();
    for (Map.Entry<Character, Integer> entry : s1Lookup.entrySet()) {
      if (entry.getValue() != -1) {
        builder.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
      }
    }

    return builder.toString().isEmpty() ? "-1" : builder.toString();
  }

  // Function to remove common characters and concatenate two strings.
  public static String concatenatedString1(String s1, String s2) {
    Map<Character, Integer> s1Lookup = new LinkedHashMap<>();
    Map<Character, Integer> s2Lookup = new LinkedHashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      s1Lookup.put(s1.charAt(i), i);
    }

    for (int i = 0; i < s2.length(); i++) {
      s2Lookup.put(s2.charAt(i), i);
    }

    String concat = s1.concat(s2);
    String output = concat;
    for (int i = 0; i < concat.length(); i++) {
      char ch = concat.charAt(i);
      if (s1Lookup.containsKey(ch) && s2Lookup.containsKey(ch)) {
        output = output.replace(String.valueOf(ch), "");
      }
    }

    return output.isEmpty() ? "-1" : output;
  }

  // Function to remove common characters and concatenate two strings.
  public static String concatenatedString2(String s1, String s2) {
    StringBuilder res = new StringBuilder();
    int i;

    // creating a hashMap to add characters in string s2
    HashMap<Character, Integer> m = new HashMap<>();
    for (i = 0; i < s2.length(); i++) {
      m.put(s2.charAt(i), 1);
    }

    // Find characters of s1 that are not present in s2 and append to result
    for (i = 0; i < s1.length(); i++) {
      if (!m.containsKey(s1.charAt(i))) {
        res.append(s1.charAt(i));
      } else {
        m.put(s1.charAt(i), 2);
      }
    }

    // Find characters of s2 that are not
    // present in s1.
    for (i = 0; i < s2.length(); i++) {
      if (m.get(s2.charAt(i)) == 1) {
        res.append(s2.charAt(i));
      }
    }

    return res.toString().isEmpty() ? "-1" : res.toString();
  }

  private static String concatenatedString3(String s1, String s2) {
    // Array to count occurrences of characters in s1
    int[] count1 = new int[26];
    // Array to count occurrences of characters in s2
    int[] count2 = new int[26];

    // Count occurrences of each character in s1
    for (char ch : s1.toCharArray()) {
      count1[ch - 'a']++;
    }

    // Count occurrences of each character in s2
    for (char ch : s2.toCharArray()) {
      count2[ch - 'a']++;
    }

    StringBuilder modified = new StringBuilder(); // StringBuilder to store the modified string

    // Iterate over s1 and check for uncommon characters
    for (char ch : s1.toCharArray()) {
      if (count2[ch - 'a'] == 0) {
        modified.append(ch);
      }
    }

    // Iterate over s2 and check for uncommon characters
    for (char ch : s2.toCharArray()) {
      if (count1[ch - 'a'] == 0) {
        modified.append(ch);
      }
    }

    if (modified.isEmpty()) {
      return "-1";
    }

    return modified.toString();
  }

  public static String concatenatedString4(String s1, String s2) {
    Map<Character, Integer> lookupStr1 = new HashMap<>();
    Map<Character, Integer> lookupStr2 = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      lookupStr1.put(s1.charAt(i), i);
    }

    for (int i = 0; i < s2.length(); i++) {
      lookupStr2.put(s2.charAt(i), i);
    }

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < s1.length(); i++) {
      if (!lookupStr2.containsKey(s1.charAt(i))) {
        builder.append(s1.charAt(i));
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!lookupStr1.containsKey(s2.charAt(i))) {
        builder.append(s2.charAt(i));
      }
    }

    return builder.toString();
  }
}
